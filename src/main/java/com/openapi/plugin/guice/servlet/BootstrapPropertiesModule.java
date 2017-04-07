package com.openapi.plugin.guice.servlet;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Guice Module to load Properties file and bind it to Guice Injector.<br>
 * Properties can later be used in constructor or field injection by using: <br>
 * <code>@Inject @Named("name.of.the.key") private String propValue;</code>
 *
 * @author pablo.biagioli
 */
public class BootstrapPropertiesModule extends AbstractModule {

    @Override
    protected void configure() {
        Properties bootstrapProperties = new Properties();
        try {
            InputStream is = getClass().getResourceAsStream("/bootstrap.properties");
            bootstrapProperties.load(is);
            Names.bindProperties(binder(), bootstrapProperties);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("I/O Exception during loading configuration");
        }
    }

}