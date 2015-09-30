package com.tangdi.dbank.action;

import java.io.OutputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.tangdi.dbank.util.MatrixToImageWriter;


/**
 * @version 1.0
 * @author Wu Gang
 * @category 二维码生成
 * @create date 2015-04-20 10:33:45
 */
public class PROC000002 extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String text = "1";
		int width = 300;
		int height = 300;
		// 二维码的图片格式 
		String format = "jpg";
		HashMap<EncodeHintType, String> hints = new HashMap<EncodeHintType, String>();
		// 内容所使用编码 
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
		// 生成二维码 
		// File outputFile = new File("d:" + File.separator + "QRcode.jpg");
		// MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
		OutputStream os = response.getOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix, format, os);
		os.flush();
		response.flushBuffer();
		os.close();
		return new ModelAndView("QRcode", "", "");
	}
}
