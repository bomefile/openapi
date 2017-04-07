package com.openapi.plugin.guice.servlet;

import com.google.inject.servlet.ServletModule;
import com.openapi.plugin.guice.mybatis.MybatisCustomerModule;
import com.openapi.plugin.guice.servlet.config.GuiceRestEasyFilterDispatcher;
import com.openapi.plugin.guice.shiro.BootstrapShiroModule;
import com.openapi.plugin.guice.shiro.ShiroAnnotationsModule;
import org.apache.shiro.guice.web.GuiceShiroFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BootstrapServletModule extends ServletModule {

    private static Logger log = LoggerFactory.getLogger(BootstrapServletModule.class);

    @Override
    protected void configureServlets() {
        super.configureServlets();

        log.info("Bootstrap Main Servlet");
        // get the bootstrapping Properties file
        install(new BootstrapPropertiesModule());
        install(new MybatisCustomerModule());
        // Initialize Persistence JPA Unit of Work if present
        // install(new MyUnitOfWorkModule());
        // Initialize Apache Shiro if present
        install(new BootstrapShiroModule(getServletContext()));
        // This allows Shiro AOP Annotations
        // http://shiro.apache.org/java-authorization-guide.html
        install(new ShiroAnnotationsModule());
        // This Module will try to bind all the classes under .rest packages
        install(new BootstrapRestPackagesModule());


        filter("/*").through(GuiceShiroFilter.class);
        filter("/*").through(GuiceRestEasyFilterDispatcher.class);

    }
}