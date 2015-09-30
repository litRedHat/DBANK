package com.tangdi.dbank.xmlbean.chip;

public class BaseRequest {
	private BaseReqHead ReqHead;
	private BaseReqBody ReqBody;

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