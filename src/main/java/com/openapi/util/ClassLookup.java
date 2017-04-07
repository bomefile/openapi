package com.openapi.util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.HashSet;
import java.util.Set;

public class ClassLookup {
    private static Set<Class<?>> classes = new HashSet<Class<?>>();

    /**
     * 获取所有src中加载的类
     *
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws URISyntaxException
     */
    public static Set<Class<?>> getUserClasses() throws IOException, ClassNotFoundException, URISyntaxException {
        if (classes.isEmpty()) {
            ClassLoader loader = ClassLookup.class.getClassLoader();
            String path = URLDecoder.decode(new File(ClassLookup.class.getResource("/").getPath()).getAbsolutePath(), "utf-8");
            if (!path.endsWith(File.separator))
                path += File.separator;
            Set<String> classpathes = scanClasses(new File(path));
            for (String child : classpathes) {
                String classpath = child.replace(path, "").replace(File.separatorChar, '.').replace(".class", "");
                Class<?> clazz = loader.loadClass(classpath);
                classes.add(loader.loadClass(classpath));
            }
        }
        return classes;
    }

    /**
     * 扫描类仅仅src中
     *
     * @param file
     * @return
     * @throws URISyntaxException
     */
    public static Set<String> scanClasses(File file) throws URISyntaxException {
        File[] childs = file.listFiles();
        Set<String> classpathes = new HashSet<>();
        for (File child : childs) {
            String path = child.getAbsolutePath();
            if (child.isDirectory()) {
                classpathes.addAll(scanClasses(child));
            } else if (path.endsWith(".class")) {
                classpathes.add(child.getAbsolutePath());
            }
        }
        return classpathes;
    }
}
