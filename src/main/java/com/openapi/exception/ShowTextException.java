package com.openapi.exception;

/**
 * 自定义异常类
 *
 * @author liuzeyuan
 */
public class ShowTextException extends Exception {

	/**
     *
     */
	private static final long	serialVersionUID	= 2415732168424760035L;

	public ShowTextException(String showText) {
		super(showText);
	}
}
