package com.tangdi.dbank.action;

import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangdi.dbank.xmlbean.chip.BaseRequest;
import com.tangdi.dbank.xmlbean.chip.req.Req7021;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.CompactWriter;

public class Test {
	private static Logger logger = LoggerFactory.getLogger(Test.class);

	public static void main(String[] args) {
		// BeanFactory beanFactory = new XmlBeanFactory(new
		// FileSystemResource("config/coober-email.xml"));

		// @SuppressWarnings("resource")
		// ApplicationContext context = new
		// ClassPathXmlApplicationContext("config/include.xml");
		// PROC000005 sendEmail = (PROC000005) context.getBean("sendMail");
		// try {
		// sendEmail.sendMsgToPeople();
		// } catch (UnsupportedEncodingException e) {
		// e.printStackTrace();
		// }

		// BaseRequest baseRequest = new BaseRequest();
		// Req7022 req7022 = new Req7022();
		// BaseReqHead reqHead = new BaseReqHead();
		// BaseReqBody reqBody = new BaseReqBody();
		// reqHead.setTransCode("7021");
		// reqHead.setChnlType(ConstantsDbank.ChnlType);
		// reqHead.setTransDate("20150819");
		// reqHead.setTransTime("154912");
		// reqHead.setTrcNo("20150819000000614752");
		// req7022.setTelephone("15618389010");
		// req7022.setContent("动态密码：389593(2分钟内有效)。您正在进行海南银行椰Bank安全认证。");
		// req7022.setProtocol("C200");
		// req7022.setTempCode("9999");
		// req7022.setSrcBranch("9999");
		// baseRequest.setReqHead(reqHead);
		// baseRequest.setReqBody(req7022);
		// XStream xs = new XStream();
		// StringWriter writer = new StringWriter();
		// xs.processAnnotations(BaseReqBody.class);
		// xs.autodetectAnnotations(true);
		// xs.aliasPackage("", "com.tangdi.dbank.xmlbean.chip");
		// xs.aliasField("Head", BaseRequest.class, "ReqHead");
		// xs.aliasField("Body", BaseRequest.class, "ReqBody");
		// xs.alias("msg", BaseRequest.class);
		// xs.setMode(XStream.NO_REFERENCES);
		// xs.toXML(baseRequest, writer);
		// logger.info("\n" + writer.toString());

		XStream xstream = new XStream();
		StringWriter wt = new StringWriter();

		Req7021 req7021 = new Req7021();
		req7021.setTelephone("15618389010");
		req7021.setContent("动态密码：389593(2分钟内有效)。您正在进行海南银行椰Bank安全认证。");
		req7021.setProtocol("C200");
		req7021.setTempCode("9999");
		BaseRequest msg = new BaseRequest(req7021);

		xstream.alias("Msg", BaseRequest.class);
		xstream.aliasField("Head", BaseRequest.class, "ReqHead");
		xstream.aliasField("Body", BaseRequest.class, "ReqBody");
		xstream.aliasSystemAttribute(null, "class");
		xstream.marshal(msg, new CompactWriter(wt));
		// xstream.toXML(msg, wt);
		logger.info("<?xml version=\"1.0\" encoding=\"gbk\"?>" + wt.toString());
	}
}