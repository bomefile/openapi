package com.openapi.plugin.provider;

import com.openapi.util.ResponseCode;
import com.openapi.util.ResponseJsonRender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RestExceptionHandler implements ExceptionMapper<Exception> {
    protected static final Logger logger = LogManager.getLogger(RestExceptionHandler.class);

    @Override
    public Response toResponse(Exception e) {
        logger.error(e.getMessage(), e);
        ResponseJsonRender render = new ResponseJsonRender(ResponseCode.ERROR, "发生未知异常", e.getMessage());
        return Response.status(200).entity(render).type(MediaType.APPLICATION_JSON).build();
    }
} 