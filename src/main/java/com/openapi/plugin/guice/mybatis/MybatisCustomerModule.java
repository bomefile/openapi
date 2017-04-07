package com.openapi.plugin.guice.mybatis;

import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.name.Names;
import com.openapi.annotation.mvc.Component;
import com.openapi.annotation.mvc.Controller;
import com.openapi.annotation.mvc.Repository;
import com.openapi.annotation.mvc.Service;
import com.openapi.annotation.quartz.Schedule;
import com.openapi.util.ClassLookup;
import com.openapi.util.StringUtil;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.druid.DruidDataSourceProvider;

import javax.inject.Singleton;
import javax.ws.rs.ext.Provider;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;


/**
 * Created by lazeyliu on 2017/1/9.
 */
public class MybatisCustomerModule extends MyBatisModule {
    protected static final Logger logger = LogManager.getLogger(MybatisCustomerModule.class);

    protected void initialize() {
        try {
            // database property bind
            Properties props = new Properties();
            // /
            InputStream is = getClass().getResourceAsStream("/dbsource.properties");
            props.load(is);
            Names.bindProperties(binder(), props);


            // mybatis settings
            bindDataSourceProviderType(DruidDataSourceProvider.class);
            useGeneratedKeys(false);
            useCacheEnabled(false);
            useColumnLabel(true);
            autoMappingBehavior(AutoMappingBehavior.FULL);
            mapUnderscoreToCamelCase(true);
            bindTransactionFactoryType(JdbcTransactionFactory.class);
            // /

            // reset bind
            Set<Class<?>> classes = ClassLookup.getUserClasses();

            for (Class<?> clazz : classes) {
                if (clazz.isAnnotationPresent(Repository.class)//
                        || clazz.isAnnotationPresent(Service.class) //
                        || clazz.isAnnotationPresent(Component.class) //
                        || clazz.isAnnotationPresent(Schedule.class) //
                        || clazz.isAnnotationPresent(Provider.class)
                        ) {
                    //
                    if (clazz.isAnnotationPresent(Repository.class)) {
                        addMapperClass(clazz);
                    } else {
                        String name = "";
                        if (clazz.isAnnotationPresent(Repository.class)) {
                            name = clazz.getAnnotation(Repository.class).value();
                        } else if (clazz.isAnnotationPresent(Service.class)) {
                            name = clazz.getAnnotation(Service.class).value();
                        } else if (clazz.isAnnotationPresent(Controller.class)) {
                            name = clazz.getAnnotation(Controller.class).value();
                        } else if (clazz.isAnnotationPresent(Component.class)) {
                            name = clazz.getAnnotation(Component.class).value();
                        }
                        if (StringUtil.isNotBlank(name)) {
                            Class<?> superClazz = clazz.getSuperclass();
                            Class<?>[] interfaceClazzes = clazz.getInterfaces();
                            if (!Object.class.equals(superClazz) || interfaceClazzes.length > 0) {
                                if (!Object.class.equals(superClazz)) {
                                    AnnotatedBindingBuilder supperClazzBinder = bind(superClazz);
                                    supperClazzBinder.annotatedWith(Names.named(name));
                                    if (clazz.isAnnotationPresent(Singleton.class)) {
                                        supperClazzBinder.asEagerSingleton();
                                    }
                                    supperClazzBinder.to(clazz);
                                }
                                for (Class<?> interfaceClazz : interfaceClazzes) {
                                    AnnotatedBindingBuilder interfaceClazzBinder = bind(interfaceClazz);
                                    interfaceClazzBinder.annotatedWith(Names.named(name));
                                    if (clazz.isAnnotationPresent(Singleton.class)) {
                                        interfaceClazzBinder.asEagerSingleton();
                                    }
                                    interfaceClazzBinder.to(clazz);
                                }
                            }
                        } else {
                            AnnotatedBindingBuilder<?> binder = bind(clazz);
                            if (clazz.isAnnotationPresent(Singleton.class)) {
                                binder.asEagerSingleton();
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
