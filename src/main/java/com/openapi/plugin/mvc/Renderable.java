package com.openapi.plugin.mvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.WebApplicationException;
import java.io.IOException;

public interface Renderable {
	public static final String	PREFIX_REDIRECT	= "redirect:";
	public static final String	PREFIX_FORWARD	= "forward:";

	/**
	 * Creates a view without a model.
	 *
	 * @param path
	 *            will be dispatched to using the servlet container; it should have a leading /.
	 */
	public void render(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, WebApplicationException;
}
