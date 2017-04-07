package com.openapi.service;

import com.openapi.entity.JxAgent;
import com.openapi.exception.ShowTextException;

import java.util.Map;

/**
 * @author liuzeyuan
 */
public interface JxAgentService {

	/**
	 * @param mobile
	 *            手机号
	 * @param password
	 *            密码
	 * @return
	 */
	JxAgent tuituiLogin(String mobile, String password);

	/**
	 * 注册经纪人
	 *
	 * @param zone
	 * @param street
	 * @param form
	 *            表单value
	 * @return 0表示正常，-1：手机号被占用，-2身份证号占用
	 */
	void tuituiRegist(String zone, String street, Map<String, String> params) throws ShowTextException;
}
