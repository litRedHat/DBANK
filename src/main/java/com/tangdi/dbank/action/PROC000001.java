package com.tangdi.dbank.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @version 1.0
 * @author Wu Gang
 * @create date 2015-04-14 13:41:03
 */
@Controller
public class PROC000001{
	
	private static final Logger logger = LoggerFactory.getLogger(PROC000001.class);
	
	@RequestMapping(value = "/index.html", produces = "text/html;charset=utf-8")
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("----------------------PROC000001 start----------------------");
		logger.info("AbsolutePath=" + new File("/").getAbsolutePath());
		logger.info("user.dir=" + System.getProperty("user.dir") );
		logger.info(getClass().getResource("/").getFile().toString());
		logger.info("RealPath=" + request.getSession().getServletContext().getRealPath(""));
		return new ModelAndView("../../index", " ", "");
	}
}
