package com.base.utils;

import java.util.UUID;

public class UUIDUtils {
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	public static String randomUUID(){
		return UUID.randomUUID().toString();
	}
}
