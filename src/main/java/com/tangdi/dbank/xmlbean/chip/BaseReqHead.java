package com.tangdi.dbank.xmlbean.chip;

public class BaseReqHead {
	private String TransCode;
	private String ChnlType;
	private String TransDate;
	private String TransTime;
	private String TrcNo;

	public String getTransCode() {
		return TransCode;
	}

	public void setTransCode(String transCode) {
		TransCode = transCode;
	}

	public String getChnlType() {
		return ChnlType;
	}

	public void setChnlType(String chnlType) {
		ChnlType = chnlType;
	}

	public String getTransDate() {
		return TransDate;
	}

	public void setTransDate(String transDate) {
		TransDate = transDate;
	}

	public String getTransTime() {
		return TransTime;
	}

	public void setTransTime(String transTime) {
		TransTime = transTime;
	}

	public String getTrcNo() {
		return TrcNo;
	}

	public void setTrcNo(String trcNo) {
		TrcNo = trcNo;
	}

}
