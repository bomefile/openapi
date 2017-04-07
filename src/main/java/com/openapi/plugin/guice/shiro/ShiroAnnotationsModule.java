package com.openapi.plugin.guice.shiro;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import org.apache.shiro.authz.annotation.*;
import org.apache.shiro.authz.aop.*;

public class ShiroAnnotationsModule extends AbstractModule {

    @Override
    protected void configure() {
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(RequiresRoles.class), new ShiroMethodInterceptor(new RoleAnnotationMethodInterceptor()));
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(RequiresUser.class), new ShiroMethodInterceptor(new UserAnnotationMethodInterceptor()));
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(RequiresPermissions.class), new ShiroMethodInterceptor(new PermissionAnnotationMethodInterceptor()));
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(RequiresGuest.class), new ShiroMethodInterceptor(new GuestAnnotationMethodInterceptor()));
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(RequiresAuthentication.class), new ShiroMethodInterceptor(new AuthenticatedAnnotationMethodInterceptor()));
    }

}