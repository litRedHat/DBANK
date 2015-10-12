package com.tangdi.dbank.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期处理工具类
 * @author Lorenz Walker
 *
 */
public class DateUtils {
	/**
	 * yyyy/MM/dd HH:mm:ss
	 */
	public static final SimpleDateFormat SDF1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	/**
	 * yyyyMMdd
	 */
	public static final SimpleDateFormat SDF2 = new SimpleDateFormat("yyyyMMdd");
	/**
	 * ddHHmmss
	 */
	public static final SimpleDateFormat SDF3 = new SimpleDateFormat("HHmmss");
	/**
	 * yyyyMMddHHmmss
	 */
	public static final SimpleDateFormat SDF4 = new SimpleDateFormat("yyyyMMddHHmmss");
	/**
	 * ddHHmmss
	 */
	public static final SimpleDateFormat SDF5 = new SimpleDateFormat("ddHHmmss");
	/**
	 * HHmmssSSS
	 */
	public static final SimpleDateFormat SDF6 = new SimpleDateFormat("HHmmssSSS");
	/**
	 * mmssSSS
	 */
	public static final SimpleDateFormat SDF7 = new SimpleDateFormat("mmssSSS");

	/**
	 * yyyy-MM-dd'T'HH:mm:ss.SSSZ
	 */
	public static final SimpleDateFormat SDF8 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
	
	/**
	 * yyyy-MM-dd'T'HH:mm:ss
	 */
	public static final SimpleDateFormat SDF9 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	
	/**
	 * 按照Date对象取得指定SimpleDateFormat格式的日期字符串。
	 * 
	 * @param date Date对象
	 * @param sdf  SimpleDateFormat格式
	 * 
	 * @return 指定格式的时间字符串。
	 */
	public static String getDateStr(Date date, SimpleDateFormat sdf) {
		if (date == null && sdf == null) {
			return "";
		}
		String dateStr = "";
		try {
			dateStr = sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateStr;

	}
}
