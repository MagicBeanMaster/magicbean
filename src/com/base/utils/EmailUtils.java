package com.base.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;


/**
 * 
 * @description 邮件信息初始化信息
 * @author lq
 * @date 2016年3月31日 上午9:43:04 
 * @version
 */
public class EmailUtils {

	protected final static String SERVERHOST = "smtp.qq.com";
	protected final static String SERVERPORT = "25";
	protected final static String USERNAME = "plat@jindinghaiju.com";
	protected final static String PASSWORD = "Jinding123";
	protected final static String TAB = "\t";
	protected static Properties properties = new Properties();
	protected static List<String> emaillArr = new ArrayList<String>();//String[]{"ayu@jindinghaiju.com"};
	protected static List<String> emaillArr1 = new ArrayList<String>();
	protected static String serverName = "";
	
	static {
		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("monitor.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String emails = properties.getProperty("email").trim();
		String emails1 = properties.getProperty("email1").trim();
		serverName = properties.getProperty("servername");
		if(StringUtils.isNotEmpty(emails)){
			emaillArr = Arrays.asList(emails.split(","));
		}else{
			emaillArr.add("ayu@jindinghaiju.com");
		}
		if(StringUtils.isNotEmpty(emails1)){
			emaillArr1 = Arrays.asList(emails1.split(","));
		}
	}
}
