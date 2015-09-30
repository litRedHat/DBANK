package com.tangdi.dbank.xmlbean.chip.req;

import com.tangdi.dbank.xmlbean.chip.BaseReqBody;

public class Req7022 extends BaseReqBody {
	private String Telephone;
	private String Content;
	private String Protocol;
	private String TempCode;
	private String SrcBranch;

	public String getTelephone() {
		return Telephone;
	}

	public void setTelephone(String telephone) {
		Telephone = telephone;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getProtocol() {
		return Protocol;
	}

	public void setProtocol(String protocol) {
		Protocol = protocol;
	}

	public String getTempCode() {
		return TempCode;
	}

	public void setTempCode(String tempCode) {
		TempCode = tempCode;
	}

	public String getSrcBranch() {
		return SrcBranch;
	}

	public void setSrcBranch(String srcBranch) {
		SrcBranch = srcBranch;
	}

}