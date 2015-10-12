package com.tangdi.dbank.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tangdi.dbank.xmlbean.chip.res.Res7021;

/**
 * springmvc-restful
 * 
 * @version 1.0
 * @author Wu Gang
 * @create date 2015-9-3
 */
@RestController
@RequestMapping("/products")
public class PROC000007 {

	private static Logger logger = LoggerFactory.getLogger(PROC000007.class);

	@RequestMapping(value = "/RestfulNoparam", method = RequestMethod.GET)
	public Res7021 restfulNoparam(HttpServletRequest request, HttpServletResponse response) {
		Res7021 res7021 = new Res7021();
		res7021.setInterest("RestfulNoparam");
		return res7021;
	}

	@RequestMapping(value = "/RestfulHasparam", method = RequestMethod.GET)
	public Res7021 restfulHasparam(@RequestParam(value = "name") String name) {
		Res7021 res7021 = new Res7021();
		res7021.setInterest("RestfulHasparam");
		return res7021;
	}

	@RequestMapping(value = "/RestfulOneParam/{id}", method = RequestMethod.GET)
	public Res7021 restfulOneParam(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
		logger.info("id=" + id);
		Res7021 res7021 = new Res7021();
		res7021.setInterest("/RestfulOneParam/{id}");
		return res7021;
	}

	@RequestMapping(value = "/RestfulTwoParam/{id}/Opration/{opration}", method = RequestMethod.GET)
	public Res7021 restfulTwoParam(@PathVariable int id, @PathVariable String opration, HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("id=" + id + ";opration=" + opration);
		Res7021 res7021 = new Res7021();
		res7021.setInterest("/RestfulTwoParam/{id}/Opration/{opration}");
		return res7021;
	}

	@RequestMapping(value = "/RestfulRetrunString/{id}", method = RequestMethod.GET)
	public String restfulRetrunString(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
		logger.info("id=" + id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("CARD_NO", "6225882140083202");
		return new JSONObject(map).toString();
	}

}