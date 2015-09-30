package com.tangdi.dbank.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 会话 cookie
 * 不包含“HttpOnly”属性注入站点的恶意脚本可能访问此cookie，并窃取它的值。任何存储在会话令牌中的信息都可能被窃取，并可用于身份盗窃或用户伪装
 * 
 * @author WuGang
 * @version 1.0
 */
public class CookieFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(CookieFilter.class);

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		/**
		 * 禁止跨域访问
		 */
		String referer = req.getHeader(HttpHeaders.REFERER);
		String requestURL = req.getRequestURL().toString();
		logger.info("-------->referer:" + referer + ",requestURL:" + requestURL);
		if (referer != null && !"null".equals(referer) && !referer.equals(requestURL)) {
			referer = referer.substring(referer.indexOf("//") + 2);
			requestURL = requestURL.substring(requestURL.indexOf("//") + 2);
			String refererIp = referer.substring(0, referer.indexOf("/"));
			String requestURLIp = requestURL.substring(0, requestURL.indexOf("/"));
			logger.info("-------->refererIp:" + refererIp + ",requestURLIp:" + requestURLIp);
			if ("weibo.com".equals(refererIp) || "www.urlshare.cn".equals(refererIp)) {
				// 分享到新浪微博和QQ空间的允许跨域访问
			} else {
				if (!refererIp.equals(requestURLIp)) {
					PrintWriter out = res.getWriter();
					out.print(" <script>alert('Forbid cross domain access.'); </script>");
					return;
				}
			}
		}
		Cookie[] cookies = req.getCookies();

		if (cookies != null) {
			Cookie cookie = cookies[0];
			if (cookie != null) {
				/*
				 * cookie.setMaxAge(3600); cookie.setSecure(true);
				 * resp.addCookie(cookie);
				 */
				// Servlet 2.5不支持在Cookie上直接设置HttpOnly属性
				String value = cookie.getValue();
				StringBuilder builder = new StringBuilder();
				builder.append("JSESSIONID=" + value + "; ");
				// builder.append("Secure; ");
				builder.append("HttpOnly; ");
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.HOUR, 1);
				Date date = cal.getTime();
				Locale locale = Locale.CHINA;
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", locale);
				builder.append("Expires=" + sdf.format(date));
				res.setHeader("Set-Cookie", builder.toString());
			}
		}
		chain.doFilter(req, res);
	}

	public void destroy() {
	}

	public void init(FilterConfig arg0) throws ServletException {
	}
}