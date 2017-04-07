/*
 *    Copyright 2012-2013 The Haohui Network Corporation
 */
package com.openapi.util;

/**
 * @file HttpUtil.java
 *
 * @brief
 * HttpUtil is a single class containing methods to conveniently perform HTTP 
 * requests. HttpUtil only uses regular java io and net functionality and does 
 * not depend on external libraries. 
 * The class contains methods to perform a get, post, put, and delete request,
 * and supports posting forms. Optionally, one can provide headers.
 *
 * Example usage:
 *
 *     // get
 *     String res = HttpUtil.get("http://www.google.com");
 *
 *     // post
 *     String res = HttpUtil.post("http://sendmedata.com", "This is the data");
 *
 *     // post form
 *     Map<String, String> params = new HashMap<String, String>();
 *     params.put("firstname", "Joe");
 *     params.put("lastname", "Smith");
 *     params.put("age", "28");
 *     String res = HttpUtil.postForm("http://site.com/newuser", params);
 *
 *     // append query parameters to url
 *     String url = "http://mydatabase.com/users";
 *     Map<String, String> params = new HashMap<String, String>();
 *     params.put("orderby", "name");
 *     params.put("limit", "10");
 *     String fullUrl = HttpUtil.appendQueryParams(url, params);
 *     // fullUrl = "http://mydatabase.com/user?orderby=name&limit=10"
 *
 * @license
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy 
 * of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 * Copyright (c) 2012 Almende B.V.
 *
 * @author Jos de Jong, <jos@almende.org>
 * @date 2012-05-14
 */

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

/**
 * https://raw.github.com/wjosdejong/httputil/master/src/com/almende/util/ HttpUtil.java
 *
 * @author cevencheng <cevencheng@gmail.com>
 * @project baidamei
 * @create 2012-11-17 下午2:35:38
 */
public class HttpUtil {
	/**
	 * Send a get request
	 *
	 * @param url
	 * @return response
	 * @throws IOException
	 */
	static public String get(String url) throws IOException {
		return get(url, null);
	}

	/**
	 * Send a get request
	 *
	 * @param url
	 *            Url as string
	 * @param headers
	 *            Optional map with headers
	 * @return response Response as string
	 * @throws IOException
	 */
	static public String get(String url, Map<String, String> headers) throws IOException {
		return fetch("GET", url, null, headers);
	}

	/**
	 * Send a post request
	 *
	 * @param url
	 *            Url as string
	 * @param body
	 *            Request body as string
	 * @param headers
	 *            Optional map with headers
	 * @return response Response as string
	 * @throws IOException
	 */
	static public String post(String url, String body, Map<String, String> headers) throws IOException {
		return fetch("POST", url, body, headers);
	}

	/**
	 * Send a post request
	 *
	 * @param url
	 *            Url as string
	 * @param body
	 *            Request body as string
	 * @return response Response as string
	 * @throws IOException
	 */
	static public String post(String url, String body) throws IOException {
		return post(url, body, null);
	}

	/**
	 * Post a form with parameters
	 *
	 * @param url
	 *            Url as string
	 * @param params
	 *            map with parameters/values
	 * @return response Response as string
	 * @throws IOException
	 */
	static public String postForm(String url, Map<String, String> params) throws IOException {
		return postForm(url, params, null);
	}

	/**
	 * Post a form with parameters
	 *
	 * @param url
	 *            Url as string
	 * @param params
	 *            Map with parameters/values
	 * @param headers
	 *            Optional map with headers
	 * @return response Response as string
	 * @throws IOException
	 */
	static public String postForm(String url, Map<String, String> params, Map<String, String> headers) throws IOException {
		// set content type
		if (headers == null) {
			headers = new HashMap<String, String>();
		}
		headers.put("Content-Type", "application/x-www-form-urlencoded");

		// parse parameters
		String body = "";
		if (params != null) {
			boolean first = true;
			for (String param : params.keySet()) {
				if (first) {
					first = false;
				} else {
					body += "&";
				}
				String value = params.get(param);
				body += URLEncoder.encode(param, "UTF-8") + "=";
				body += URLEncoder.encode(value, "UTF-8");
			}
		}

		return post(url, body, headers);
	}

	/**
	 * Send a put request
	 *
	 * @param url
	 *            Url as string
	 * @param body
	 *            Request body as string
	 * @param headers
	 *            Optional map with headers
	 * @return response Response as string
	 * @throws IOException
	 */
	static public String put(String url, String body, Map<String, String> headers) throws IOException {
		return fetch("PUT", url, body, headers);
	}

	/**
	 * Send a put request
	 *
	 * @param url
	 *            Url as string
	 * @return response Response as string
	 * @throws IOException
	 */
	static public String put(String url, String body) throws IOException {
		return put(url, body, null);
	}

	/**
	 * Send a delete request
	 *
	 * @param url
	 *            Url as string
	 * @param headers
	 *            Optional map with headers
	 * @return response Response as string
	 * @throws IOException
	 */
	static public String delete(String url, Map<String, String> headers) throws IOException {
		return fetch("DELETE", url, null, headers);
	}

	/**
	 * Send a delete request
	 *
	 * @param url
	 *            Url as string
	 * @return response Response as string
	 * @throws IOException
	 */
	static public String delete(String url) throws IOException {
		return delete(url, null);
	}

	/**
	 * Append query parameters to given url
	 *
	 * @param url
	 *            Url as string
	 * @param params
	 *            Map with query parameters
	 * @return url Url with query parameters appended
	 * @throws IOException
	 */
	static public String appendQueryParams(String url, Map<String, String> params) throws IOException {
		String fullUrl = new String(url);

		if (params != null) {
			boolean first = (fullUrl.indexOf('?') == -1);
			for (String param : params.keySet()) {
				if (first) {
					fullUrl += '?';
					first = false;
				} else {
					fullUrl += '&';
				}
				String value = params.get(param);
				fullUrl += URLEncoder.encode(param, "UTF-8") + '=';
				fullUrl += URLEncoder.encode(value, "UTF-8");
			}
		}

		return fullUrl;
	}

	/**
	 * Retrieve the query parameters from given url
	 *
	 * @param url
	 *            Url containing query parameters
	 * @return params Map with query parameters
	 * @throws IOException
	 */
	static public Map<String, String> getQueryParams(String url) throws IOException {
		Map<String, String> params = new HashMap<String, String>();

		int start = url.indexOf('?');
		while (start != -1) {
			// read parameter name
			int equals = url.indexOf('=', start);
			String param = "";
			if (equals != -1) {
				param = url.substring(start + 1, equals);
			} else {
				param = url.substring(start + 1);
			}

			// read parameter value
			String value = "";
			if (equals != -1) {
				start = url.indexOf('&', equals);
				if (start != -1) {
					value = url.substring(equals + 1, start);
				} else {
					value = url.substring(equals + 1);
				}
			}

			params.put(URLDecoder.decode(param, "UTF-8"), URLDecoder.decode(value, "UTF-8"));
		}

		return params;
	}

	/**
	 * Returns the url without query parameters
	 *
	 * @param url
	 *            Url containing query parameters
	 * @return url Url without query parameters
	 * @throws IOException
	 */
	static public String removeQueryParams(String url) throws IOException {
		int q = url.indexOf('?');
		if (q != -1) {
			return url.substring(0, q);
		} else {
			return url;
		}
	}

	/**
	 * Send a request
	 *
	 * @param method
	 *            HTTP method, for example "GET" or "POST"
	 * @param url
	 *            Url as string
	 * @param body
	 *            Request body as string
	 * @param headers
	 *            Optional map with headers
	 * @return response Response as string
	 * @throws IOException
	 */
	static public String fetch(String method, String url, String body, Map<String, String> headers) throws IOException {
		// connection
		URL u = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) u.openConnection();
		conn.setConnectTimeout(10000);
		conn.setReadTimeout(10000);

		// method
		if (method != null) {
			conn.setRequestMethod(method);
		}

		// headers
		if (headers != null) {
			for (String key : headers.keySet()) {
				conn.addRequestProperty(key, headers.get(key));
			}
		}

		// body
		if (body != null) {
			conn.setDoOutput(true);
			OutputStream os = conn.getOutputStream();
			os.write(body.getBytes());
			os.flush();
			os.close();
		}
		boolean isGzip = false;
		String charset = null;
		// response
		if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {

			// for (int i = 0;; i++) {
			// String headerName = conn.getHeaderFieldKey(i);
			String contentEncoding = conn.getHeaderField("Content-Encoding");
			if (contentEncoding != null && contentEncoding.equalsIgnoreCase("gzip")) {
				isGzip = true;
			}
			String contentType = conn.getHeaderField("Content-Type");
			charset = getCharsetFromContentType(contentType);
		}
		InputStream is = conn.getInputStream();
		String response = streamToString(is, charset, isGzip);
		is.close();

		// handle redirects
		if (conn.getResponseCode() == 301) {
			String location = conn.getHeaderField("Location");
			return fetch(method, location, body, headers);
		}

		return response;
	}

	//
	/**
	 * 字符集编码
	 */
	private static final Pattern	charsetPattern	= Pattern.compile("(?i)\\bcharset=\\s*(?:\"|')?([^\\s,;\"']*)");

	/**
	 * 检测网页编码
	 *
	 * @param contentType
	 * @return
	 */
	static String getCharsetFromContentType(String contentType) {
		if (contentType == null)
			return null;
		Matcher m = charsetPattern.matcher(contentType);
		if (m.find()) {
			String charset = m.group(1).trim();
			charset = charset.replace("charset=", "");
			if (charset.length() == 0)
				return null;
			try {
				if ("gb2312".equalsIgnoreCase(charset) || "gbk".equalsIgnoreCase(charset)) {
					charset = "gb18030";
				}
				if (Charset.isSupported(charset))
					return charset;
				charset = charset.toUpperCase(Locale.ENGLISH);
				if (Charset.isSupported(charset))
					return charset;
			} catch (IllegalCharsetNameException e) {
				// if our advanced charset matching fails.... we just take the
				// default
				return null;
			}
		}
		return null;
	}

	/**
	 * Read an input stream into a string
	 *
	 * @param in
	 * @return
	 * @throws IOException
	 */
	static public String streamToString(InputStream is, String charset, boolean isGzip) throws IOException {
		if (charset == null || "".equals(charset.trim())) {
			charset = "utf-8";
		}
		BufferedReader reader = null;
		if (isGzip) {
			reader = new BufferedReader(new InputStreamReader(new GZIPInputStream(is), charset));// 设置编码,否则中文乱码
		} else {
			reader = new BufferedReader(new InputStreamReader(is, charset));// 设置编码,否则中文乱码
		}
		String line = "";
		StringBuffer result = new StringBuffer();
		while (null != (line = reader.readLine())) {
			if (!"".equals(line)) {
				result.append(line).append("\r\n");
			}
		}

		return result.toString();
	}

	public static void main(String[] args) throws IOException {
		// System.out.println(get("http://esf.tj.fang.com/housing/46__0_0_0_0_1_0_0/"));
		// System.out.println(get("http://www.guokr.com/post/576237/"));

	}
}
