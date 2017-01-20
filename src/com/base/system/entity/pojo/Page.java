package com.base.system.entity.pojo;

import java.util.HashMap;
import java.util.Map;


public class Page {
	
	private Integer pageNum;//当前页数
	private Integer pageSize;//每页显示的条数
	private String keys;//关键字
	private Map<String, Object> paramsMap = new HashMap<String, Object>();//查询的条件(字段，字段值)
	
	
	public Integer getPageNum() {
		if(pageNum==null)
			pageNum = 1;
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		if(pageSize==null)
			pageSize = 10;
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public Integer getStartIndex() {
		return (this.getPageNum()-1)*this.getPageSize();
	}
	
	public String getKeys() {
		return keys;
	}
	public void setKeys(String keys) {
		this.keys = keys;
	}
	
	public Map<String, Object> getParamsMap() {
		return paramsMap;
	}
	public void setParamsMap(Map<String, Object> paramsMap) {
		this.paramsMap = paramsMap;
	}
	public void setParams(String key,Object vlaues){
		paramsMap.put(key, vlaues);
	}
	
	
}
