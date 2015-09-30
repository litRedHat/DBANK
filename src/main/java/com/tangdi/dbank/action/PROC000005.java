package com.tangdi.dbank.action;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

/**
 * 发送邮件
 * 
 * @author WuGang
 * @create date 2015-6-15 19:20:24
 */
@Controller
public class PROC000005 {
	@Autowired
	public JavaMailSender mailSender;
	@Autowired
	private SpringTemplateEngine templateEngine;

	private static Logger logger = LoggerFactory.getLogger(PROC000005.class);

	@ResponseBody
	@RequestMapping(value = "/sendEmail.html", produces = "text/html;charset=utf-8")
	public String sendMsgToPeople(HttpServletRequest req, HttpServletResponse res) {
		logger.info("进入发送邮件功能");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("resFlag", "N");
		try {
			/**
			 * 发送带有附件的邮件
			 */
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setTo("421584998@qq.com");
			helper.setFrom("海南银行直销银行<" + "playleud@163.com" + ">");
			helper.setSubject("海南银行椰Bank重置登陆密码");
			FileSystemResource image = new FileSystemResource("E:/apache-tomcat-7.0.62-mars/webapps/DBANK/favicon.ico");
			helper.addAttachment("icon", image);
			FileSystemResource grilImage = new FileSystemResource(
					"E:/apache-tomcat-7.0.62-mars/webapps/DBANK/beautiful.jpg");
			helper.addInline("beautifulGirl", grilImage);
			Context ctx = new Context();
			ctx.setVariable("name", "WuGang");
			String emailText = templateEngine.process("hello.html", ctx);
			helper.setText(emailText, true);
			mailSender.send(mimeMessage);

			/**
			 * 发送普通文本邮件
			 */
			// SimpleMailMessage message = new SimpleMailMessage();
			// message.setTo("421584998@qq.com");
			// message.setFrom("海南银行直销银行<" + "playleud@163.com" + ">");
			// message.setSubject("海南银行椰Bank重置登陆密码");
			// message.setText(
			// "尊敬的XXX客户：\n 您好!\n
			// 您于X年X月X日X时X分进行的海南银行椰Bank登录密码找回操作，验证码为72716d，验证码有效期为邮件发送后2小时内，请您尽快完成操作。
			// 若有疑问，您可以拨打我行客户服务热线：96566（省外：0898-96566）。\n 此为系统邮件，请勿回复。");
			// mailSender.send(message);
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.getMessage());
			resultMap.put("resFlag", "E");
		}
		return new JSONObject(resultMap).toString();
	}
}