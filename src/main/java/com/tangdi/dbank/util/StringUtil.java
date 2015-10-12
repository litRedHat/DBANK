package com.tangdi.dbank.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 字符串处理
 * 
 * @author Lorenz Walker
 *
 */
public class StringUtil {

	/**
	 * 将数字前补制定位数0，转成字符串<br>
	 * <code>
	 * 		int i = 9;<br>
	 * 		String str = StringUtil.valueOf(9, 4); //	0009
	 * </code>
	 * 
	 * @param number
	 *            需要处理的字符串
	 * @param length
	 *            数字补足的位数（不能超过数字本身的长度）
	 * @return 前补零后的数字字符串
	 */
	public static String valueOf(int number, int length) {
		String str = String.valueOf(number);
		while (str.length() < length) {
			str = "0" + str;
		}
		return str;
	}

	/**
	 * 
	 * @param orgStr
	 * @param length
	 * @return
	 */
	public static String addZero(String orgStr, int length) {

		while (orgStr.length() < length) {
			orgStr = "0" + orgStr;
		}
		return orgStr;
	}

	/**
	 * 将字符串转成GBK编码的长度，然后补足空格<br>
	 * <code>
	 * 		String str1 = "abc";<br>
	 * 		String s1 = StringUtil.addBlank(str1, 5); 	//	"abc  "<br>
	 * 		String str2	= "你好吗";<br>
	 * 		String s2 = StringUtil.addBlank(str2, 10); 	//	"你好吗    "<br>
	 * 		String str3	= "唐宁街１０号";<br>
	 * 		String s3 = StringUtil.addBlank(str3, 15);	//	"唐宁街１０号   "<br>
	 * 		String str3	= "唐宁街１０号";<br>
	 * 		String s3 = StringUtil.addBlank(str3, 11);	//	"唐宁街１０"<br>
	 * 		String str3	= "唐宁街10号";<br>
	 * 		String s3 = StringUtil.addBlank(str3, 15);	//	"唐宁街10号     "<br>
	 * </code>
	 * 
	 * @param str
	 *            需要处理的字符串
	 * @param length
	 *            补足的位数
	 * @return 处理后的字符串
	 */
	public static String addBlank(String str, int length) {
		if (str == null) {
			str = "";
		} else {
			str = str.trim();
		}
		int gbkLength = getInclueChineseCharacterStrLength(str);
		while (getInclueChineseCharacterStrLength(str) > length) {
			str = str.substring(0, str.length() - 1);
		}
		String blank = "";
		while (gbkLength + blank.length() < length) {
			blank += " ";
		}
		str = str + blank;
		return str;
	}

	/**
	 * 计算所有包含双字节字符（包含所有中文字符）的长度
	 * 
	 * @param str
	 *            需要处理的字符串
	 * @return 字符串包含双字节字符的长度（双字节长度为2）
	 */
	private static int getInclueChineseCharacterStrLength(String str) {
		Matcher m = Pattern.compile("[^x00-xff]").matcher(str);
		int count = 0;
		while (m.find()) {
			count++;
		}
		return str.length() + count;
	}

	/**
	 * 汉字转换位汉语拼音，英文字符不变
	 * 
	 * @param chines
	 *            汉字
	 * @return 拼音
	 */
	public static String converterToSpell(String chines) {
		String pinyinName = "";
		char[] nameChar = chines.toCharArray();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		// 小写
		// defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		// 大写
		defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		for (int i = 0; i < nameChar.length; i++) {
			if (nameChar[i] > 128) {
				try {
					// pinyinName +=
					// PinyinHelper.toHanyuPinyinStringArray(nameChar[i],
					// defaultFormat)[0]+" ";
					if (i < nameChar.length - 1) {
						pinyinName += PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0] + " ";
					} else {
						pinyinName += PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0];
					}
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					pinyinName = "";
				}
			} else {
				pinyinName += nameChar[i];
			}
		}
		return pinyinName;
	}

	/**
	 * 判断当前对象是否为非空
	 * 
	 * @param str
	 * @return true:非空，false：空
	 */
	public static boolean checkDataNull(String str) {
		if (str != null && !"".equals(str.trim()) && !"null".equals(str.trim())) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return true：为空，false：不为空
	 */
	public static boolean isNullOrEmpty(String str) {
		if (str == null || "".equals(str.trim()) || "null".equals(str.trim()))
			return true;
		else
			return false;
	}

	/**
	 * 根据币种英文缩写进行转型为币种编号
	 * 
	 * @param str
	 *            0344 HKD 港币 0392 JPY 日本元 0446 MOP 澳门元 0702 SGD 新加坡元 0156 CNY
	 *            人民币 0978 EUR 欧元 0826 GBP 英镑 0756 CHF 瑞士法郎 0124 CAD 加拿大元 0840
	 *            USD 美元 0036 AUD 澳大利亚元
	 */
	public static String moneyToNo(String type) {
		if (type == "HKD") {// 港币
			return "0344";
		} else if (type == "JPY") // 日本元
		{
			return "0392";
		} else if (type == "MOP") // 澳门元
		{
			return "0446";
		} else if (type == "SGD") // 新加坡元
		{
			return "0702";
		} else if (type == "CNY") // 人民币
		{
			return "0156";
		} else if (type == "EUR") // 欧元
		{
			return "0978";
		} else if (type == "GBP") // 英镑
		{
			return "0826";
		} else if (type == "CHF") // 瑞士法郎
		{
			return "0756";
		} else if (type == "CAD") // 加拿大元
		{
			return "0124";
		} else if (type == "USD") // 美元
		{
			return "0840";
		} else if (type == "AUD") // 澳大利亚元
		{
			return "0036";
		} else if (type == "AUD") // 澳大利亚元
		{
			return "0036";
		} else {
			return "0000";
		}
	}

	/**
	 * 根据币种编号进行转型为英文缩写
	 * 
	 * @param str
	 *            0344 HKD 港币 0392 JPY 日本元 0446 MOP 澳门元 0702 SGD 新加坡元 0156 CNY
	 *            人民币 0978 EUR 欧元 0826 GBP 英镑 0756 CHF 瑞士法郎 0124 CAD 加拿大元 0840
	 *            USD 美元 0036 AUD 澳大利亚元
	 */
	public static String moneyToEngNm(String type) {
		if (type == "0344") {// HKD 港币
			return "HKD";
		} else if (type == "0392") // JPY 日本元
		{
			return "JPY";
		} else if (type == "0446") // MOP 澳门元
		{
			return "MOP";
		} else if (type == "0702") // SGD 新加坡元
		{
			return "SGD";
		} else if (type == "0156") // CNY 人民币
		{
			return "CNY";
		} else if (type == "0978") // EUR 欧元
		{
			return "EUR";
		} else if (type == "0826") // GBP 英镑
		{
			return "GBP";
		} else if (type == "0756") // CHF 瑞士法郎
		{
			return "CHF";
		} else if (type == "0124") // CAD 加拿大元
		{
			return "CAD";
		} else if (type == "0840") // USD 美元
		{
			return "USD";
		} else if (type == "0036") // AUD 澳大利亚元
		{
			return "AUD";
		} else if (type == "0036") // AUD 澳大利亚元
		{
			return "AUD";
		} else {
			return "EEE";
		}
	}
}
