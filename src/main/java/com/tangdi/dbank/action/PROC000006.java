package com.tangdi.dbank.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version 1.0
 * @author Wu Gang
 * @create date 2015-6-15
 */
@Controller
public class PROC000006 {

	@Autowired
	private SqlSessionTemplate sqlSession;
	private static Logger logger = LoggerFactory.getLogger(PROC000006.class);

	@ResponseBody
	@RequestMapping(value = "/recomment/loadImg.do", produces = "text/html;charset=utf-8")
	public String ajaxDatas(HttpServletRequest req, HttpServletResponse res) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> param1 = new HashMap<String, Object>();
		Map<String, Object> param2 = new HashMap<String, Object>();
		Map<String, Object> param3 = new HashMap<String, Object>();
		List<Map<String, Object>> imgList = new ArrayList<Map<String, Object>>();
		param.put("retCode", "E000000000");
		param.put("retFlag", "N");
		param.put("retMsg", "[0xe6][0x88][0x90][0xe5][0x8a][0x9f]");
		param1.put("backup1", "1");
		param1.put("href", null);
		param1.put("id", "032015042200000002");
		param1.put("picName", "index_banner02_PC");
		param1.put("picType", "01");
		param1.put("relEndTime", null);
		param1.put("relStartTime", "20150422010101");
		param1.put("shareDesc", null);
		param1.put("url", "http:\\192.168.0.96:10001\\mall\\image\\banner-1.png");
		param1.put("version", 20150422);
		param2.put("backup1", "1");
		param2.put("href", null);
		param2.put("id", "032015042200000003");
		param2.put("picName", "index_banner04_PC");
		param2.put("picType", "01");
		param2.put("relEndTime", null);
		param2.put("relStartTime", "20150422010101");
		param2.put("shareDesc", null);
		param2.put("url", "http:\\192.168.0.96:10001\\mall\\image\\banner-3.png");
		param2.put("version", 20150422);
		param3.put("backup1", "1");
		param3.put("href", null);
		param3.put("id", "032015042200000004");
		param3.put("picName", "index_banner03_PC");
		param3.put("picType", "01");
		param3.put("relEndTime", null);
		param3.put("relStartTime", "20150422010101");
		param3.put("shareDesc", null);
		param3.put("url", "http:\\192.168.0.96:10001\\mall\\image\\index_banner03_PC.jpg");
		param3.put("version", 20150422);
		imgList.add(param1);
		imgList.add(param2);
		imgList.add(param3);
		param.put("imgList", imgList);
		return new JSONObject(param).toString();
	}
}