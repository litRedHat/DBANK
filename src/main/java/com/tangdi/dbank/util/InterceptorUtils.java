package com.tangdi.dbank.util;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

/**
 * 拦截器工具类
 * 
 * @author WuGang
 *
 */
public class InterceptorUtils {

	/**
	 * 判断一个HTTP请求是否为一个AJAX请求
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isAjaxRequest(HttpServletRequest request) {
		String requestType = request.getHeader("X-Requested-With");
		if (requestType != null && requestType.equals("XMLHttpRequest")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 从request流中读取json数据
	 * 
	 * @param request
	 * @return
	 */
	public static String readJsonFromIO(HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader reader = request.getReader();
			char[] buff = new char[1024];
			int len;
			while ((len = reader.read(buff)) != -1) {
				sb.append(buff, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * 判断请求方发送的
	 * @param request
	 * @return
	 */
	public static Boolean isJson(HttpServletRequest request) {
		if(request.getContentType() != null && -1 != request.getContentType().indexOf("application/json")){
			return true;
		}else{
			return false;
		}
	}
}
