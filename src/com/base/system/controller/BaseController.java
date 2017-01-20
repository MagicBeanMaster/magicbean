package com.base.system.controller;


import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.base.system.entity.pojo.Page;
import com.base.system.services.plat.TSysErrorService;
import com.base.utils.ExceptionUtils;


/**
 * 
 * action基类
 * 
 * @since 2015-08-11
 * @version 1.0
 * @author liangxiaoyu
 *
 */
public  class BaseController {
	
	@Resource
	private TSysErrorService tSysErrorService;
	
	@ExceptionHandler
	public ModelAndView exp(HttpServletRequest request, Exception ex) {
		String refurl = request.getRequestURI();
		ModelAndView m = new ModelAndView("../error");
		m.addObject("ex", ex);
		ExceptionUtils.dealException(ex,refurl,tSysErrorService);
		return m;
	}
	
	/**
	 * 
	 * @description 初始化分页相关信息 
	 * @param map 数据
	 * @param pageNum 当前页数
	 * @param pageSize 每页显示的条数
	 * @param totalCount 数据总条数
	 * @date 2015年10月16日 
	 */
	protected void initPage(Map<String,Object> map, Integer pageNum, Integer pageSize){  
        if(null==pageSize || pageSize==0){  
            pageSize = 10;  
        }  
        if(pageSize>50){  
            pageSize = 50;  
        }  
        if(null==pageNum){  
            pageNum = 1;  
        }
        
        Integer startIndex = 0;  
        if(pageNum>0){  
        	startIndex = (pageNum-1)*pageSize;  
        }  
        map.put("startIndex", startIndex);  
        map.put("pageNum", pageNum);  
        map.put("pageSize", pageSize);  
    }
	
	/**
	 * 
	 * @description 存储分页数据 
	 * @param mv
	 * @param page
	 * @date 2016年4月5日 上午11:50:31
	 */
	protected void setPageAttr(ModelAndView mv,Page page){
		mv.addObject("pageNum",page.getPageNum());
		mv.addObject("pageSize", page.getPageSize());
		mv.addObject("keys", page.getKeys()!=null?page.getKeys().trim():null);
		mv.addObject("startIndex", page.getStartIndex());
		Map<String,Object> map = page.getParamsMap();
		if(map.keySet().size()>0){
			for (String s : map.keySet()) {
				if(map.get(s)!=null)
					mv.addObject(s, map.get(s));
			}
		}
	}
      
   
}
