package com.base.constant;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * 共用常量类
 * @since 2015-08-20
 * @version 1.0
 * @author liangxy
 *
 */
public class Constant {
	
	//系统 0 和1 的标示 
	public static final int STATUS_0 = 0; // 不正常  比如 已删除  已作废  或者 否 离职  等标示 
	public static final int STATUS_1 = 1; // 正常  比如 未删除  为作废  或者 是 未离职 等标示
	
	// 短信模板编号
	public static final String MESSAGE_TEMPLATE_VERIFICATION = "67154"; 
	public static final String MESSAGE_TEMPLATE ="【金鼎海居】-短信验证:您的验证码是{1},请于{2}分钟内正确输入.";
	
	//手机验证码有效时间(分钟)
	public static final int PHONE_CAPTCHA_EXPIRY_MINUTE = 2;
	
	
	
	public static String FILESPLIT="/";

	public static String basePath = "";
	public static final String str = "://";
	public static final String str1 = ":";
	public static final String str2 = "/";
	public static String SYSTEMROOTPATH = str2;//判断系统分隔符
	public static String IP = "";
	public static String PICTUREPATH;
	public static List<String> ERRORLIST = new ArrayList<String>(5);
	public static String RESROURSEPATH = "";
	public static final long MEMORY = Runtime.getRuntime().maxMemory()*10/100;//
	public static List<String> NOVLIDATEPATH = new ArrayList<String>(100);
	public static String BACKINDEXPATH = null;
	public static String PICPATH;
	public static String BACKTIME;
	public static String BACKPATH;
	
	static {
		
		Properties properties1 = new Properties();
		try {
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("server.properties");
			properties1.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Constant.PICTUREPATH = properties1.getProperty("picturepath");
		Constant.RESROURSEPATH = properties1.getProperty("resroursepath");
		String errormesss = properties1.getProperty("errormess").trim();
		if(StringUtils.isNotEmpty(errormesss)){
			Constant.ERRORLIST = Arrays.asList(errormesss.split(",")) ;
		}
		
	}
	
	
	
	
	
}
