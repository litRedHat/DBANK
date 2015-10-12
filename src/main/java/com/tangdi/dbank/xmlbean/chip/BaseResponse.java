package com.tangdi.dbank.xmlbean.chip;

import com.tangdi.dbank.xmlbean.chip.res.BaseResBody;
import com.tangdi.dbank.xmlbean.chip.res.BaseResHead;

public class BaseResponse {
	private BaseResHead ResHead;
	private BaseResBody ResBody;

	public BaseResponse(BaseResBody resBody) {
		super();
		this.ResBody = resBody;
	}

	public BaseResHead getResHead() {
		return ResHead;
	}

	public void setResHead(BaseResHead resHead) {
		ResHead = resHead;
	}

	public BaseResBody getResBody() {
		return ResBody;
	}

	public void setResBody(BaseResBody resBody) {
		ResBody = resBody;
	}

}