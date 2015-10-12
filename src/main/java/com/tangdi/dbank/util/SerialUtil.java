package com.tangdi.dbank.util;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

public class SerialUtil {
	private static final AtomicLong counter = new AtomicLong();

	/**
	 * 生成20位流水号
	 * 
	 * @return
	 */
	public static String GenerationSerialNum() {
		String atomicNum = String.valueOf(counter.incrementAndGet());
		while (atomicNum.length() < 6) {
			atomicNum = "0" + atomicNum;
		}

		String result = DateUtils.getDateStr(new Date(), DateUtils.SDF2)
				+ DateUtils.getDateStr(new Date(), DateUtils.SDF3) + atomicNum;

		return result;
	}
}
