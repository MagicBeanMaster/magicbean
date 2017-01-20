package com.base.utils;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringUtils {
	public final static int size = 1* 1024*1024; 
	public static boolean validate(Object o){
		if(null == o) return false;
		String temp = o.toString().trim();
		if(temp.length()<=0 || "".equals(temp)) return false;
		return true;
	}
	
	public static boolean validateStrSize(String str){
		boolean flag=false;
		int t=str.getBytes(Charset.forName("utf-8")).length;
		if(t<=size){
			flag=true;
		}
		return flag;
	}
	
	public static String convertor(Object o){
		if(validate(o)) return o.toString();
		else return "";
	}
	public static void convertor1(Object o,Double d){
		System.out.println("i am void ");
	}
	public static String convertor2(String ss,String oo){
		return (ss+oo).toUpperCase();
	}
	
	/**
	 * 将字符串按字典序排
	 * @param s
	 * @return
	 */
	public static String[] sort(String[] s){
		List<String> list = new ArrayList<String>(s.length);
		for (String str : s) {
			list.add(str);
		}
		Collections.sort(list);
		return list.toArray(s);
	}
	
	/**
	 * 对字段串长度校验
	 * @param s
	 * @return
	 */
	public static boolean MaxLength(String s,int length){
		boolean flag=false;
		if(s!=null &&s.length()>length){
			flag=true;
		}
		return flag;
	}
	
	
}
