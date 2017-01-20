package com.base.bases;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


public class BaseRequestWrapper extends HttpServletRequestWrapper {
	private static final String SqlKeyWords = "'|and|exec|insert|select|delete|update|count|[*]|%|chr|mid|master|truncate|char|declare|;|[+]|<|>";  
	private static final String FGF = "\\|";
	public BaseRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		String content=super.getParameter(name);
		if(content==null || "".equals(content)) return null;
		content = content.replaceAll("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]", "");//过滤emoji表情
		content = content.replaceAll("</?[^<]+>", "");// 过滤文章内容中的html
		content = content.replaceAll("\\s*|\t|\r|\n", "");// 去除字符串中的空格 回车 换行符 制表符 等
		content = content.replaceAll("&nbsp;", "");// 去除空格
		String[] inj_stra=SqlKeyWords.split(FGF);  
		for (String key : inj_stra) content = content.replaceAll(key, "");
		return content;
	}

}
