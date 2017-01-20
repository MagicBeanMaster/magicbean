
package com.base.utils;

import java.io.*;
import java.net.*;
import java.util.regex.*;

import javax.servlet.http.*;

/**
 * 网络  工具
 * @author hujiang
 * @time 2015年9月1日15:34:21
 */
public class NetUtils {
	private static final Pattern PATTERN_IP = Pattern.compile("^([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}$");
	 
	 /**
	  * URI 解码
	  * @param s uri字符串
	  * @return 编码过后的字符串uri
	  * @date 2015年9月1日 下午4:29:27
	  */
	public static String decodeURIComponent(String s)
	{
		if (s == null)
		{
			return null;
		}
		
		String result = null;
		try
		{
			result = URLDecoder.decode(s, "UTF-8");
		}
		catch (UnsupportedEncodingException e)
		{
			result = s;  
		}

		return result;
	}

	/**
	 * 加密uri
	 * @param s 未加密uri
	 * @return 加密的uri
	 * @date 2015年9月1日 下午4:31:16
	 */
	public static String encodeURIComponent(String s)
	{
		String result = null;

		try
		{
			result = URLEncoder.encode(s, "UTF-8")
						.replaceAll("\\+", "%20")
						.replaceAll("\\%21", "!")
						.replaceAll("\\%27", "'")
						.replaceAll("\\%28", "(")
						.replaceAll("\\%29", ")")
						.replaceAll("\\%7E", "~");
		}
		catch (UnsupportedEncodingException e)
		{
			result = s;
		}

		return result;
	}
	
	
	/**
	 * 获取ip地址
	 * @param request 请求request
	 * @return ip地址
	 * @date 2015年9月1日 下午4:34:12
	 */
	public static String getIp(HttpServletRequest request)
	{
		String ip = getValidIp(request.getHeader("x-forwarded-for"));
		if(ip == null)
		{
			ip = getValidIp(request.getHeader("Proxy-Client-IP"));
		}
		if(ip == null)
		{
			ip = getValidIp(request.getHeader("WL-Proxy-Client-IP"));
		}
		if(ip == null)
		{   
			ip = getValidIp(request.getRemoteAddr());  
		}
		return ip;
	}
	/**
	 * 获取浏览器
	 * @param request
	 * @return
	 * @date 2015年9月1日 下午4:35:03
	 */
	public static String getBrowser(HttpServletRequest request)
	{
		String browser = request.getHeader("user-agent");
		
		return browser;
	}
	
	/**
	 * 获得有效的ip
	 * @param content
	 * @return
	 * @date 2015年9月1日 下午4:35:31
	 */
	private static String getValidIp(String content)
	{
		String ip = null;
		if(content != null && content.isEmpty() == false && content.equalsIgnoreCase("unknown") == false)
		{
			if(content.indexOf(",") > -1)
			{
				String[] contents = content.split(",");
				content = null;
				for(int i = 0; i < contents.length; i++)
				{
					content = getValidIp(contents[i]);
					if(content != null)
					{
						break;
					}
				}
			}
			content = content.trim();
			if(PATTERN_IP.matcher(content).matches() == true)
			{
				ip = content;
			}
		}
		return ip;
	}
	
	
	public static String getMultipartFileName(Part part)
	{
		String name = null;
		String header = part.getHeader("content-disposition");
		if(header != null)
		{
			String[] values = header.split(";");
			for(int i = 0; i < values.length; i++)
			{
				String content = values[i].trim();
				if (content.toLowerCase().startsWith("filename") == true)
				{
					name = content.substring(content.indexOf('=') + 1).replace("\"", "");
					break;
				}
			}
		}
		return name;
	}
	/**
	 * 从part 中获取文件类型
	 * @param part
	 * @return 文件类型
	 * @date 2015年9月1日 下午4:39:59
	 */
	public static String getMultipartFileType(Part part)
	{
		String type = null;
		String name = getMultipartFileName(part);
		if(name != null)
		{
			int index = name.lastIndexOf('.');
			if(index > 0 && index < name.length() - 1)
			{
				type = name.substring(index + 1).toLowerCase();
			}
		}
		return type;
	}

}
