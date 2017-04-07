package com.openapi.plugin.mvc.jsp;

import org.jboss.resteasy.spi.InternalServerErrorException;

import com.openapi.plugin.mvc.Renderable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.WebApplicationException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class View extends LinkedHashMap<String, Object> implements Renderable {
	/**
     *
     */
	private static final long	serialVersionUID	= -5611253607673129718L;
	protected String			path;

	public View(String path) {
		this.path = path;
	}

	@Override
	public void render(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, WebApplicationException {
		boolean isForward = true;
		if (path.startsWith(PREFIX_REDIRECT)) {
			path = path.replaceFirst(PREFIX_REDIRECT, "");
			isForward = false;
		} else {
			path = path.replaceFirst(PREFIX_FORWARD, "");
		}
		this.path = (path.startsWith("/") ? path : "/" + path);
		if (isForward) {
			RequestDispatcher disp = request.getRequestDispatcher(path);
			if (disp == null)
				throw new InternalServerErrorException("No dispatcher found for path '" + path + "'");
			disp.forward(request, response);
		} else {
			for (Entry<String, Object> entry : this.entrySet()) {
				request.setAttribute(entry.getKey(), entry.getValue());
			}
		}
	}
}
