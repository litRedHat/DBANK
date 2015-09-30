package com.tangdi.dbank.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	@RequestMapping(value = "/index.html", produces = "text/html;charset=utf-8")
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new ModelAndView("../../index", " ", "");
	}
}
