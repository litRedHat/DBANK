package com.tangdi.dbank.base;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.XMLContext;
import org.springframework.beans.factory.annotation.Autowired;

public class XMLMessageEngine {
	@Autowired
	public Map<String, XMLContext> requestXMLContexts;
	/** XmlContext的集合 */
	@Autowired
	public Map<String, XMLContext> responseXMLContexts;
	/** XmlContext的集合 */
	@Autowired
	public Map<String, Object> properties;

	public void setRequestXMLContexts(Map<String, XMLContext> requestXMLContexts) {
		this.requestXMLContexts = requestXMLContexts;
	}

	public void setResponseXMLContexts(Map<String, XMLContext> responseXMLContexts) {
		this.responseXMLContexts = responseXMLContexts;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

	public String toMessage(Object object, String transCode) {
		StringWriter writer = new StringWriter();
		String xmlStr = "";
		try {
			// 此处应该同步，castor非线程安全
			synchronized (requestXMLContexts) {
				XMLContext xmlContext = requestXMLContexts.get(transCode);
				Marshaller marshaller = xmlContext.createMarshaller();
				marshaller.setWriter(writer);
				marshaller.setEncoding("GBK");
				marshaller.marshal(object);
				xmlStr = (writer.toString()).replaceAll("\n", "");
				System.out.println("xmlStr:" + xmlStr);
				String hasLength = (String) properties.get("hasLength");
				if ("true".equals(hasLength)) {
					String format = properties.get("msgBodyLength") == null ? "4"
							: properties.get("msgBodyLength").toString();
					xmlStr = String.format("%0" + format + "d",
							xmlStr.getBytes((String) properties.get("encoding")).length) + xmlStr;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xmlStr;
	}

	public Object toObject(String realXml, String transCode) {
		try {
			// 此处应该同步，castor非线程安全
			synchronized (responseXMLContexts) {
				XMLContext xmlContext = responseXMLContexts.get(transCode);
				Unmarshaller unmarshaller = xmlContext.createUnmarshaller();
				StringReader reader = new StringReader(realXml);
				Object object = unmarshaller.unmarshal(reader);
				return object;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}