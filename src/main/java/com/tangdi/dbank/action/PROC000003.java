package com.tangdi.dbank.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * 文件下载
 * 
 * @author WuGang
 * @create date 2015-6-15 19:20:14
 */
public class PROC000003 extends AbstractController {
	public static final Logger logger = LoggerFactory.getLogger(PROC000003.class);

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		PROC000003.download(request, response);
		return null;
	}

	public static Boolean download(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("PROC000003");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		String downLoadPath = "C:/1.txt";
		File file = new File(downLoadPath);
		if (!file.exists()) {
			logger.info("<<<<<<<<<<<<<下载文件不存在>>>>>>>>>>>>>>");
			return false;
		}
		long fileLength = file.length();
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment; filename="
				+ new String("HABNK".getBytes("gb2312"), "iso-8859-1"));
		response.setHeader("Content-Length", String.valueOf(fileLength));

		bis = new BufferedInputStream(new FileInputStream(downLoadPath));
		bos = new BufferedOutputStream(response.getOutputStream());
		byte[] buff = new byte[2048];
		int bytesRead;
		while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
			bos.write(buff, 0, bytesRead);
		}
		bis.close();
		bos.close();
		return true;
	}
}