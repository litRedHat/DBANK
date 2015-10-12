package com.tangdi.dbank.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.XmlMappingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tangdi.dbank.base.BaseAction;

/**
 * @version 1.0
 * @author Wu Gang
 * @create date 2015-6-15
 */
@Controller
public class PROC000004 extends BaseAction {

	@Autowired
	private SqlSessionTemplate sqlSession;
	// @Autowired
	// private XMLMessageEngine chipMessageEngine;

	private static Logger logger = LoggerFactory.getLogger(PROC000004.class);

	@ResponseBody
	@RequestMapping(value = "/hello.html", produces = "text/html;charset=utf-8")
	public String ajaxDatas(HttpServletRequest req, HttpServletResponse res)
			throws JSONException, XmlMappingException, IOException {
		// Req7021 req7021 = new Req7021();
		// req7021.setTransCode("7021");
		// req7021.setChnlType("10");
		// req7021.setTransDate("20150819");
		// req7021.setTransTime("154912");
		// req7021.setTrcNo("20150819000000614752");
		// req7021.setTelephone("15618389010");
		// req7021.setContent("动态密码：389593(2分钟内有效)。您正在进行海南银行椰Bank安全认证。");
		// req7021.setProtocol("C200");
		// req7021.setTempCode("9999");
		// req7021.setSrcBranch("9999");
		// /**
		// * 编组XML
		// */
		// String xml = chipMessageEngine.toMessage(req7021, "7021");
		// Map<String, Object> param = new HashMap<String, Object>(2);
		// param.put("USER_ID", req.getParameter("USER_ID"));
		// Map<String, Object> resultMap =
		// this.sqlSession.selectOne("COOBER_USER_INFO.Select", param);
		// resultMap.put("xml", xml);
		// logger.info(new JSONObject(resultMap).toString());
		//
		// String in = "<?xml version=\"1.0\"
		// encoding=\"UTF-8\"?><Msg><Head><TransCode>7021</TransCode><TransDate>20150819</TransDate><TransTime>154912</TransTime><TrcNo>20150819000000614752</TrcNo><ResCode>6048</ResCode><ResMsg>连接短信平台失败</ResMsg></Head></Msg>";
		// /**
		// * 解组XML
		// */
		// Res7021 Res7021 = (Res7021) chipMessageEngine.toObject(in, "7021");
		// logger.info(Res7021.getResMsg());
		// return new JSONObject(resultMap).toString();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("xml", "N");
		return new JSONObject(resultMap).toString();
	}
}
