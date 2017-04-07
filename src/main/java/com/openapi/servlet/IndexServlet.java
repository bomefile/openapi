package com.openapi.servlet;

import com.google.inject.Inject;
import com.openapi.annotation.mvc.Controller;
import com.openapi.service.JxAgentService;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author liuzeyuan
 */
@Controller
@Path("/")
public class IndexServlet extends BaseServlet {

    @Inject
    @Named("JxAgentServiceImpl")
    private JxAgentService jxAgentService;

    @Path("/")
    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String index() {
        jxAgentService.tuituiLogin("asdfasdf", "asddddd");
        System.out.println("4#########");
        System.out.println("4#########");
        System.out.println("4#########");
        System.out.println("4#########");
        System.out.println("4#########");
        System.out.println("123123" + "   ");
        return "123123";
    }

    @Inject
    @GET
    @Path("/test")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        //test.clean();
        return "123123";
    }

}
