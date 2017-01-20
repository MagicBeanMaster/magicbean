package com.base.utils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @description http请求工具类 
 * @author lq
 * @date 2015年12月1日 上午10:20:34 
 * @version
 */
public class HttpUtils {

	/**
	 * 
	 * @description http请求返回一个JSONObject对象 
	 * @param url 请求地址
	 * @param params 请求参数
	 * @return
	 * @throws IOException
	 * @date 2015年12月1日 上午10:21:06
	 */
	public static JSONObject getHttpContext(String  url,Map<String,String> params) throws IOException{
		JSONObject json=null;
		
		Connection con= Jsoup.connect(url).data(params).ignoreContentType(true).ignoreHttpErrors(true).timeout(15000);//5s超时
		if(con != null ){
			Response resp = con.execute();
			Document doc = null;
			if (resp.statusCode() == 200) {
			    doc = con.get();
			    if(StringUtils.isNotEmpty(doc.body().toString())){
			    	try {
						json = JSONObject.parseObject(doc.body().text());
					} catch (Exception e) {
						json = new JSONObject();
						json.put("returndatas", doc.body().text());
					}
			    }
			    
			}
		}
		return json;
	}
	
	
	public static String  getIPByDomainName(String name){
		InetAddress address = null;
		try {
			address = InetAddress.getByName(name);
			if(address==null)
				return null;
		} catch (UnknownHostException e) {
			return null;
		}
		return address.getHostAddress().toString();
	}
	
	
}
