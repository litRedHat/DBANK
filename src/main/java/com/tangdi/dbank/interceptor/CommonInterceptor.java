package com.tangdi.dbank.interceptor;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.tangdi.dbank.util.InterceptorUtils;

/**
 * @version 1.0
 * @author Wu Gang
 * @date 2015-04-14 13:43:00
 */
public class CommonInterceptor implements HandlerInterceptor {

	private static Logger logger = LoggerFactory.getLogger(CommonInterceptor.class);

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		logger.info("====================================="+request.getServletPath()+" end=====================================");
		logger.info("\n");
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		arg0.setCharacterEncoding("UTF-8");
	}

	@SuppressWarnings("unchecked")
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		response.setHeader("Access-Control-Allow-Origin", "*");//允许哪些url可以跨域请求到本域
		response.setHeader("Access-Control-Allow-Methods", "POST");//允许的请求方法，一般是GET,POST,PUT,DELETE,OPTIONS
		response.setHeader("Access-Control-Allow-Headers","X-Requested-With,content-type,accept");//允许哪些请求头可以跨域
		response.addHeader("Access-Control-Max-Age", "60");
		logger.info("====================================="+request.getServletPath()+" start=====================================");
		request.setCharacterEncoding("UTF-8");
		if (InterceptorUtils.isJson(request)) {
			// 传送的是json数据
			String json = InterceptorUtils.readJsonFromIO(request);
			logger.info("json:" + json);
			JSONObject jSONObject = new JSONObject(json);
		} else {
			Map<String, String[]> map = request.getParameterMap();
			if(!map.isEmpty()){
				Set<Entry<String, String[]>> set = map.entrySet();
				Iterator<Entry<String, String[]>> it = set.iterator();
				StringBuffer sb = new StringBuffer();
				while (it.hasNext()) {
					Entry<String, String[]> entry = it.next();
					for (String i : entry.getValue()) {
						sb.append(entry.getKey() + "=" + i + "&");
					}
				}
				logger.info("请求参数:" + sb.substring(0, sb.length() - 1));
			}else{
				logger.info("请求参数:");
			}
		}
		return true;
	}
}