package com.base.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机字符串
 * @author hujiang
 * @time 2015年9月1日15:34:21
 */
public class RandomUtils {

	private static final char[] CHAR_UPPER = new char[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79,
			80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90 };
	private static final char[] CHAR_LOWER = new char[] { 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109,
			110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122 };
	private static final char[] CHAR_DIGIT = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57 };
	private static final char[] CHAR_SYMBOL = new char[] { 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47,
			58, 59, 60, 61, 62, 63, 64, 91, 92, 93, 94, 95, 96, 123, 124, 125, 126 };

	/**
	 * 随机返回指定长度的字符串：
	 * @param length 指定返回字符串长度
	 * @return 返回字符串
	 * @time 2015年9月1日15:34:21
	 */
	public static String getRandomString(int length) {
		return getRandomString(length, true);
	}
	/**
	 * 返回指定长度的字符串
	 * @param length 返回字符串长度
	 * @param includeLetter 是否加入字母，true  全大写字母 ， false 全数字
	 * @return 返回字符串
	 * @date 2015年9月1日 下午4:03:49
	 */
	public static String getRandomString(int length, boolean includeLetter) {
		return getRandomString(length, includeLetter, false);
	}
	/**
	 * 返回指定长度的字符串
	 * @param length 返回字符串长度
	 * @param includeLetter  是否加入大写字母，true  加入大写字母； false 不加入大写字母
	 * @param includeCase    是否加入小写字母，true  加入小写字母；false  不加入小写字母
	 * @return 返回字符串
	 * @date 2015年9月1日 下午4:07:34
	 */
	public static String getRandomString(int length, boolean includeLetter, boolean includeCase) {
		return getRandomString(length, includeLetter, includeCase, true);
	}
	
	/**
	 * 
	 * @param length 返回指定长度的字符串
	 * @param includeLetter 是否加入大写字母，true  加入大写字母； false 不加入大写字母
	 * @param includeCase   是否加入小写字母，true  加入小写字母；false  不加入小写字母
	 * @param includeDigit  是否加入数字，true 加入数字；false 不加入数字
	 * @return 返回字符串
	 * @date 2015年9月1日 下午4:11:13
	 */
	public static String getRandomString(int length, boolean includeLetter, boolean includeCase, boolean includeDigit) {
		return getRandomString(length, includeLetter, includeCase, includeDigit, false);
	}
	/**
	 * 
	 * @param length 返回指定长度字符串
	 * @param includeLetter  是否加入大写字母，true  加入大写字母； false 不加入大写字母
	 * @param includeCase    是否加入小写字母，true  加入小写字母；false  不加入小写字母
	 * @param includeDigit   是否加入数字，true 加入数字；false 不加入数字
	 * @param includeSymbol  是否加入可打印字符，true 加入字符；false 不加入数字 
	 * @return
	 * @date 2015年9月1日 下午4:13:10
	 */
	public static String getRandomString(int length, boolean includeLetter, boolean includeCase, boolean includeDigit,
			boolean includeSymbol) {
		StringBuilder sb = new StringBuilder();
		if (length > 0) {
			int arrayLength = 0;
			if (includeLetter == true) {
				arrayLength += CHAR_UPPER.length;
				if (includeCase == true) {
					arrayLength += CHAR_LOWER.length;
				}
			}
			if (includeDigit == true) {
				arrayLength += CHAR_DIGIT.length;
			}
			if (includeSymbol == true) {
				arrayLength += CHAR_SYMBOL.length;
			}

			char[] chars = new char[arrayLength];
			int i = 0;
			int end = 0;
			if (includeLetter == true) {
				end += CHAR_UPPER.length;
				for (; i < end; i++) {
					chars[i] = CHAR_UPPER[i];
				}
				if (includeCase == true) {
					end += CHAR_LOWER.length;
					for (; i < end; i++) {
						chars[i] = CHAR_LOWER[i % CHAR_LOWER.length];
					}
				}
			}
			if (includeDigit == true) {
				end += CHAR_DIGIT.length;
				for (; i < end; i++) {
					chars[i] = CHAR_DIGIT[i % CHAR_DIGIT.length];
				}
			}
			if (includeSymbol == true) {
				end += CHAR_SYMBOL.length;
				for (; i < end; i++) {
					chars[i] = CHAR_SYMBOL[i % CHAR_SYMBOL.length];
				}
			}

			ThreadLocalRandom r = ThreadLocalRandom.current();
			for (i = 0; i < length; i++) {
				sb.append((char) chars[r.nextInt(0, chars.length)]);
			}
		}
		return sb.toString();
	}

}
