package com.tangdi.dbank.xmlbean.chip;

import com.tangdi.dbank.xmlbean.chip.req.BaseReqBody;
import com.tangdi.dbank.xmlbean.chip.req.BaseReqHead;

public class BaseRequest {
	private BaseReqHead ReqHead;
	private BaseReqBody ReqBody;

	public BaseRequest(BaseReqBody reqBody, String transCode) {
		super();
		this.ReqHead = new BaseReqHead(transCode);;
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