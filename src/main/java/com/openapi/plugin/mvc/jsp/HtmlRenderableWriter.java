package com.openapi.plugin.mvc.jsp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.openapi.plugin.mvc.Renderable;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import static org.jboss.resteasy.spi.ResteasyProviderFactory.getContextData;

/**
 * @author Jeff Schnitzer <jeff@infohazard.org>
 */
@Provider
@Produces("text/html")
@SuppressWarnings("rawtypes")
public class HtmlRenderableWriter implements MessageBodyWriter<Renderable> {

	// @Override
	public long getSize(Renderable obj, Class type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// No chance of figuring this out ahead of time
		return -1;
	}

	// @Override
	public boolean isWriteable(Class type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return Renderable.class.isAssignableFrom(type);
	}

	// @Override
	public void writeTo(Renderable viewingPleasure, Class type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
		try {
			viewingPleasure.render(getContextData(HttpServletRequest.class), getContextData(HttpServletResponse.class));
		} catch (ServletException ex) {
			throw new WebApplicationException(ex);
		}
	}
}
