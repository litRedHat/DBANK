package com.tangdi.dbank.action;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version 1.0
 * @author Wu Gang
 * @create date 2015-6-15
 */
@Controller
public class PROC100004 {

	@Autowired
	private SqlSessionTemplate sqlSession;
	private static Logger logger = LoggerFactory.getLogger(PROC100004.class);

	@ResponseBody
	@RequestMapping(value = "/ajax.do", produces = "text/html;charset=utf-8")
	public String ajaxDatas(@RequestBody String requestbody) throws JSONException {
		logger.info("requestbody:" + requestbody);
		JSONObject jSONObject = new JSONObject(requestbody);
		Map<String, Object> param = new HashMap<String, Object>(2);
		param.put("USER_ID", jSONObject.get("USER_ID"));
		Map<String, Object> resultMap = this.sqlSession.selectOne("COOBER_USER_INFO.Select", param);
		logger.info(new JSONObject(resultMap).toString());
		return new JSONObject(resultMap).toString();
	}
}
