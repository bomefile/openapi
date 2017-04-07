package com.openapi.plugin.guice.jedis;

import com.google.inject.Inject;
import com.openapi.annotation.aop.IntercepterBy;
import com.openapi.annotation.mvc.Component;
import com.openapi.entity.JxAgent;
import com.openapi.interceptor.Intercept;
import com.openapi.interceptor.Intercept2;

/**
 * Created by roo on 15/7/4.
 */
@Component
@IntercepterBy({Intercept.class, Intercept2.class})
public class Test {


    public void clean(){
        System.out.println("_+_+_+_+_+_+_+_+_+clean");
        JxAgent j =new JxAgent();
        
    }
}
