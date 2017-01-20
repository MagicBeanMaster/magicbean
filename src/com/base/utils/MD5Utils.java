package com.base.utils;



/*
 * MD5 加密
*/
public class MD5Utils {
	
    /**
     * 
     * @description md5加密字符串 
     * @param strObj 字符串
     * @return 加密后的字符串
     * @date 2015年10月20日 上午11:13:59
     */
    public static String GetMD5Encrypt(String strObj) {
        return org.apache.commons.codec.digest.DigestUtils.md5Hex(strObj);
    }

    /**
	 * 字符串转换unicode
	 */
	public static String string2Unicode(String string) {
	    StringBuffer unicode = new StringBuffer();
	    for (int i = 0; i < string.length(); i++) {
	        // 取出每一个字符
	        char c = string.charAt(i);
	        // 转换为unicode
	        unicode.append("\\u" + Integer.toHexString(c));
	    }
	    return unicode.toString();
	}
	
	/**
	 * unicode 转字符串
	 */
	public static String unicode2String(String unicode) {
	    StringBuffer string = new StringBuffer();
	    String[] hex = unicode.split("\\\\u");
	    for (int i = 1; i < hex.length; i++) {
	        // 转换出每一个代码点
	        int data = Integer.parseInt(hex[i], 16);
	        // 追加成string
	        string.append((char) data);
	    }
	    return string.toString();
	}
}