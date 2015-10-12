package com.tangdi.dbank.xmlbean.chip;

import com.tangdi.dbank.xmlbean.chip.req.BaseReqBody;
import com.tangdi.dbank.xmlbean.chip.req.BaseReqHead;

public class BaseRequest {
	private BaseReqHead ReqHead;
	private BaseReqBody ReqBody;

	public BaseRequest(BaseReqBody reqBody) {
		super();
		BaseReqHead head = new BaseReqHead();
		head.setTransCode("7021");
		head.setChnlType("10");
		head.setTransDate("20151012");
		head.setTransTime("154912");
		head.setTrcNo("20150819000000614752");
		this.ReqHead = head;
		this.ReqBody = reqBody;
	}

	public BaseReqHead getReqHead() {
		return ReqHead;
	}

	public void setReqHead(BaseReqHead reqHead) {
		ReqHead = reqHead;
	}

	public BaseReqBody getReqBody() {
		return ReqBody;
	}

	public void setReqBody(BaseReqBody reqBody) {
		ReqBody = reqBody;
	}

}