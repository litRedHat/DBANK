package com.tangdi.dbank.base;

import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangdi.dbank.util.StringUtil;
import com.tangdi.dbank.xmlbean.chip.BaseRequest;
import com.tangdi.dbank.xmlbean.chip.BaseResponse;
import com.tangdi.dbank.xmlbean.chip.req.BaseReqBody;
import com.tangdi.dbank.xmlbean.chip.res.BaseResBody;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.CompactWriter;

/**
 * chip communication compent
 * 
 * @version 1.0
 * @author Wu Gang
 * @create date 2015-8-19
 */
public class ChipCommAction {

	private static Logger logger = LoggerFactory.getLogger(ChipCommAction.class);
	private static XStream xs = null;
	private static final String XmlDeclaration = "<?xml version=\"1.0\" encoding=\"gbk\"?>";

	/**
	 * 组装并且发送xml报文到渠道整合平台
	 */
	public BaseResponse sendAndRecieve(BaseReqBody reqbody, String transCode) {
		if (xs == null) {
			xs = new XStream();
		}
		StringWriter wt = new StringWriter();
		BaseRequest request = new BaseRequest(reqbody, transCode);
		xs.alias("Msg", BaseRequest.class);
		xs.aliasField("Head", BaseRequest.class, "ReqHead");
		xs.aliasField("Body", BaseRequest.class, "ReqBody");
		xs.aliasSystemAttribute(null, "class");
		// 加上xml头
		xs.marshal(request, new CompactWriter(wt.append(XmlDeclaration)));
		// 添加报文长度到报文头(不含自身)
		String requestMsg = StringUtil.valueOf(wt.toString().length(), 8) + wt.toString();
		logger.info("Original request message:" + requestMsg);

		/* send tcp request */

		String responseMsg = "00000296<?xml version=\"1.0\" encoding=\"gbk\"?><Msg><Head><TransCode>7021</TransCode><ChnlType>10</ChnlType><TransDate>20151012</TransDate><TransTime>155529</TransTime><TrcNo>20151012155529000196</TrcNo><Mac>201510121555290001961245978645</Mac><ResCode>0000</ResCode><ResMsg>交易成功</ResMsg></Head><Body><Interest>1.23</Interest></Body></Msg>";
		logger.info("Original response message:" + responseMsg);
		XStream xs = new XStream();
		xs.alias("Msg", BaseResponse.class);
		xs.aliasField("Head", BaseResponse.class, "ResHead");
		xs.aliasField("Body", BaseResponse.class, "ResBody");

		String className = "com.tangdi.dbank.xmlbean.chip.res." + "Res" + transCode;
		try {
			xs.alias("BaseResBody", BaseResBody.class, Class.forName(className));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		responseMsg = responseMsg.replace("<?xml version=\"1.0\" encoding=\"gbk\"?>", "").substring(8);
		logger.debug("stay unmarshall xml:" + responseMsg);
		BaseResponse response = (BaseResponse) xs.fromXML(responseMsg);
		return response;
	}
}