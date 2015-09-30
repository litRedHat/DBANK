package com.tangdi.dbank.base;

import java.io.StringWriter;

/**
 * @version 1.0
 * @author Wu Gang
 * @create date 2015-8-24
 */
public class ChipBaseAction {
	public String MarshallerToXml() {
		StringWriter writer = new StringWriter();
//		this.marshaller_7021.marshal(reqBase, new StreamResult(writer));
		return writer.toString();
	}

}
