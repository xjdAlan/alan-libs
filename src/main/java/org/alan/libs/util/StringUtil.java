package org.alan.libs.util;

import java.util.ArrayList;
import java.util.List;


/**
 * 字符或字符串的常用操作封装
 * Alan
 * 2015-1-20 下午10:01:31
 */
public class StringUtil {
	/**
	 * 判断字符串是否为空或空串
	 * Alan
	 * @param string
	 * @return
	 * 2015-1-20 下午10:03:40
	 */
	public static boolean isNullOrEmpty(String string) {
		return null == string || string.length() == 0;
	}

	/**
	 * 判定是否是Integer.MIN_VALUE ~ Integer.MAX_VALUE间的整数字符串
	 * Alan
	 * @param string
	 * @return
	 * 2015-1-20 下午10:04:46
	 */
	public static boolean isInteger(String string) {
		if (isNullOrEmpty(string)) return false;

		char f = string.charAt(0);
		if (f == '-') {
			if (string.length() > MIN_INT_STRING.length()) return false;

			for (int n = 1; n < string.length(); n++) {
				if (isNumberChar(string.charAt(n))) continue;

				return false;
			}

			if (string.length() < MIN_INT_STRING.length()) return true;
			for (int n = 1; n < string.length(); n++) {
				int mc = MIN_INT_STRING.charAt(n);
				int sc = string.charAt(n);

				if (sc > mc) return false;
			}

			return true;
		}
		else
			return isPositiveInteger(string);
	}

	/**
	 * 判定是否是正常0 ~ Integer.MAX_VALUE间的整数字符串
	 * Alan
	 * @param string
	 * @return
	 * 2015-1-20 下午10:05:11
	 */
	public static boolean isPositiveInteger(String string) {
		if (isNullOrEmpty(string) || string.length() > MAX_INT_STRING.length()) return false;

		for (int n = 0; n < string.length(); n++) {
			if (isNumberChar(string.charAt(n))) continue;

			return false;
		}

		if (string.length() < MAX_INT_STRING.length()) return true;

		for (int n = 0; n < string.length(); n++) {
			int mc = MAX_INT_STRING.charAt(n);
			int sc = string.charAt(n);

			if (sc > mc) return false;
		}

		return true;
	}

	/**
	 * 判定是否是Long.MIN_VALUE ~ Long.MAX_VALUE间的长整数字符串
	 * Alan
	 * @param string
	 * @return
	 * 2015-1-20 下午10:05:29
	 */
	public static boolean isLong(String string) {
		if (isNullOrEmpty(string)) return false;

		char f = string.charAt(0);
		if (f == '-') {
			if (string.length() > MIN_LONG_STRING.length()) return false;

			for (int n = 1; n < string.length(); n++) {
				if (isNumberChar(string.charAt(n))) continue;

				return false;
			}

			if (string.length() < MIN_LONG_STRING.length()) return true;
			for (int n = 1; n < string.length(); n++) {
				int mc = MIN_LONG_STRING.charAt(n);
				int sc = string.charAt(n);

				if (sc > mc) return false;
			}

			return true;
		}
		else
			return isPositiveLong(string);
	}

	/**
	 * 判定是否是正常0 ~ Long.MAX_VALUE间的长整数字符串
	 * Alan
	 * @param string
	 * @return
	 * 2015-1-20 下午10:05:50
	 */
	public static boolean isPositiveLong(String string) {
		if (isNullOrEmpty(string) || string.length() > MAX_LONG_STRING.length()) return false;

		for (int n = 0; n < string.length(); n++) {
			if (isNumberChar(string.charAt(n))) continue;

			return false;
		}

		if (string.length() < MAX_LONG_STRING.length()) return true;

		for (int n = 0; n < string.length(); n++) {
			int mc = MAX_LONG_STRING.charAt(n);
			int sc = string.charAt(n);

			if (sc > mc) return false;
		}

		return true;
	}

	/**
	 * 是否是浮点数
	 * Alan
	 * @param str
	 * @return
	 * 2015-1-20 下午10:06:08
	 */
	public static boolean isDouble(String str) {
		if (StringUtil.isNullOrEmpty(str)) return false;

		int n = 0;
		if (str.charAt(0) == '-') n++;

		int pSize = 0;
		boolean p = false;
		for (; n < str.length(); n++) {
			char c = str.charAt(n);
			if (c == '.') {
				if (p) return false;
				p = true;
				continue;
			}

			if (!isNumberChar(c)) return false;

			if (!p) pSize++;
		}

		return pSize > 0;
	}

	/**
	 * 判定字符是否是数字
	 * Alan
	 * @param c
	 * @return
	 * 2015-1-20 下午10:06:25
	 */
	public static boolean isNumberChar(char c) {
		return c >= '0' && c <= '9';
	}

	/**
	 * 是否是大写字母
	 * Alan
	 * @param c
	 * @return
	 * 2015-1-20 下午10:06:34
	 */
	public static boolean isUppercase(char c) {
		return c >= 'A' && c <= 'Z';
	}

	/**
	 * 是否是小写字母
	 * Alan
	 * @param c
	 * @return
	 * 2015-1-20 下午10:06:44
	 */
	public static boolean isLowercase(char c) {
		return c >= 'a' && c <= 'z';
	}

	/**
	 * 是否是字母
	 * Alan
	 * @param c
	 * @return
	 * 2015-1-20 下午10:06:54
	 */
	public static boolean isLetter(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
	}

	/**
	 * 是否是中文
	 * Alan
	 * @param c
	 * @return
	 * 2015-1-20 下午10:07:02
	 */
	public static boolean isChinese(char c) {
		return c >= 0x4e00 && c <= 0x9fa5;
	}

	/**
	 * 是否是到分钟的时间字符串，形如： HH:mm
	 * Alan
	 * @param str
	 * @return
	 * 2015-1-20 下午10:07:11
	 */
	public static boolean isTimeMinutesFormat(String str) {
		if (StringUtil.isNullOrEmpty(str)) return false;

		String[] split = str.split(":");
		if (split.length != 2) return false;

		String hourStr = split[0];// .trim();
		String minuStr = split[1];// .trim();
		if (!isPositiveInteger(hourStr) || !isPositiveInteger(minuStr)) return false;

		int hour = Integer.parseInt(hourStr);
		int minu = Integer.parseInt(minuStr);

		return hour >= 0 && hour <= 23 && minu >= 0 && minu <= 59;
	}

	/**
	 * 判断是否是11位手机号码
	 * Alan
	 * @param str
	 * @return
	 * 2015-1-20 下午10:07:22
	 */
	public static boolean isMobilePhoneNumber(String str) {
		if (isNullOrEmpty(str) || str.length() != 11 || !isPositiveLong(str)) return false;

		return str.charAt(0) == '1';
	}

	/**
	 * 获取一个字符串中的阿拉伯数字
	 * Alan
	 * @param str
	 * @return
	 * 2015-1-20 下午10:07:32
	 */
	public static List<String> getAllRealNumberFromString(String str) {
		List<String> list = new ArrayList<String>();
		if (StringUtil.isNullOrEmpty(str)) return list;

		StringBuffer buffer = new StringBuffer();
		for (int n = 0; n < str.length(); n++) {
			char c = str.charAt(n);
			if (isNumberChar(c) || c == '.' || c == '-') buffer.append(c);
			else {
				if (buffer.length() == 0) continue;

				String strBuff = buffer.toString();
				if (isDouble(strBuff)) {
					list.add(strBuff);
				}

				buffer.delete(0, buffer.length());
			}
		}

		String strBuff = buffer.toString();
		if (isDouble(strBuff)) {
			list.add(strBuff);
		}

		return list;
	}

	// ------------------------------------------------------------------------------------------------
	private static String MAX_INT_STRING = Integer.toString(Integer.MAX_VALUE);
	private static String MIN_INT_STRING = Integer.toString(Integer.MIN_VALUE);
	private static String MAX_LONG_STRING = Long.toString(Long.MAX_VALUE);
	private static String MIN_LONG_STRING = Long.toString(Long.MIN_VALUE);

	// -------------------------------------------------------------------------------------------------
	/**
	 * 半角转全角
	 * Alan
	 * @param input
	 * @return
	 * 2015-1-20 下午10:08:00
	 */
	public static String ToSBC(String input) {
		char c[] = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == ' ') 
				c[i] = '\u3000';
			else if (c[i] < '\177') 
				c[i] = (char) (c[i] + 65248);
		}
		return new String(c);
	}

	/**
	 * 全角转半角
	 * Alan
	 * @param input
	 * @return
	 * 2015-1-20 下午10:08:35
	 */
	public static String ToDBC(String input) {

		char c[] = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == '\u3000')
				c[i] = ' ';
			else if (c[i] > '\uFF00' && c[i] < '\uFF5F')
				c[i] = (char) (c[i] - 65248);
		}
		String returnString = new String(c);

		return returnString;
	}
	
	public static boolean containsChinese(String str) {
		for (int i = 0; i < str.length(); i++) {
			char ic = str.charAt(i);
			if (isChinese(ic)) return true;
		}
		return false;
	}
	public static boolean isAllChinese(String str) {
		for (int i = 0; i < str.length(); i++) {
			char ic = str.charAt(i);
			if (!isChinese(ic)) return false;
		}
		return true;
	}
	public static boolean isLetters(String letters) {
		if (StringUtil.isNullOrEmpty(letters)) return false;

		for (int n = 0; n < letters.length(); n++) {
			char c = letters.charAt(n);
			if (!isLetter(c)) return false;
		}
		return true;
	}
}
