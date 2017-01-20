package com.base.utils;

public class SqlUtils {
	private static final String SqlKeyWords = "'|and|exec|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|;|+|,";  
	private static final String FGF = "\\|";
	public static boolean sqlInj(String str)  {  
		String[] inj_stra=SqlKeyWords.split(FGF);  
		for (String key : inj_stra){  
			if (str.indexOf(key)>-1){  
				return true;  
			}  
		 }  
		 return false;  
	}  
}
