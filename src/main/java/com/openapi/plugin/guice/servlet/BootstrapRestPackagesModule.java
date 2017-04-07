package com.openapi.plugin.guice.servlet;

import com.google.inject.AbstractModule;
import com.openapi.util.ClassLookup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Path;
import java.util.Set;

public class BootstrapRestPackagesModule extends AbstractModule {

    private static final Logger logger = LoggerFactory.getLogger(BootstrapRestPackagesModule.class);

    @Override
    protected void configure() {
        Set<Class<?>> classes = null;
        try {
            classes = ClassLookup.getUserClasses();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        for (Class clazz : classes) {
            if (clazz.isAnnotationPresent(Path.class)) {
                bind(clazz);
            }
        }
    }
}