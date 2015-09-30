package com.tangdi.dbank.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

/**
 * @version 1.0
 * @author Wu Gang
 * @create date 2015-8-19
 */
@Controller
public class BaseAction {
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return new ModelAndView("", " ", "");
	}
}
