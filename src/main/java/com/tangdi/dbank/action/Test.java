package com.tangdi.dbank.action;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangdi.dbank.base.ChipCommAction;
import com.tangdi.dbank.xmlbean.chip.BaseResponse;
import com.tangdi.dbank.xmlbean.chip.req.Req7021;
import com.tangdi.dbank.xmlbean.chip.res.Res7021;

public class Test {
	private static Logger logger = LoggerFactory.getLogger(Test.class);

	private static final AtomicLong counter = new AtomicLong();

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

		Req7021 req7021 = new Req7021();
		req7021.setTelephone("15618389010");
		req7021.setContent("动态密码：389593(2分钟内有效)。您正在进行海南银行椰Bank安全认证。");
		req7021.setProtocol("C200");
		req7021.setTempCode("9999");
		ChipCommAction cca = new ChipCommAction();
		BaseResponse response = cca.sendAndRecieve(req7021, "7021");
		logger.info(response.getResHead().getChnlType());
		logger.info(((Res7021) response.getResBody()).getInterest());
		
	}
}