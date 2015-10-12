package com.tangdi.dbank.xmlbean.chip.res;

import java.util.Date;

import com.tangdi.dbank.util.ConstantsDbank;
import com.tangdi.dbank.util.DateUtils;
import com.tangdi.dbank.util.SerialUtil;

public class BaseResHead {
	private String TransCode;
	private String ChnlType;
	private String TransDate;
	private String TransTime;
	private String TrcNo;
	private String Mac;
	private String ResCode;
	private String ResMsg;

	public BaseResHead(String transCode) {
		super();
		TransCode = transCode;
		ChnlType = ConstantsDbank.ChnlType;
		TransDate = DateUtils.getDateStr(new Date(), DateUtils.SDF2);
		TransTime = DateUtils.getDateStr(new Date(), DateUtils.SDF3);
		TrcNo = SerialUtil.GenerationSerialNum();
	}

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

	public String getMac() {
		return Mac;
	}

	public void setMac(String mac) {
		Mac = mac;
	}

	public String getResCode() {
		return ResCode;
	}

	public void setResCode(String resCode) {
		ResCode = resCode;
	}

	public String getResMsg() {
		return ResMsg;
	}

	public void setResMsg(String resMsg) {
		ResMsg = resMsg;
	}
}