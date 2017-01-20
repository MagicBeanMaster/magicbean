package com.base.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
/**
 * spring帮助类
 * @since 2015-08-11
 * @version 1.0
 * @author liangxy
 */
public class SpringUtils implements ApplicationContextAware{
	private static ApplicationContext context;
	public static ApplicationContext getSpringContext(){
		return context;
	}
	
	public static Object getServiceByName(String name){
		return getSpringContext().getAutowireCapableBeanFactory().getBean(name);
	}
	
	public static <T> T getService(Class<?> cla){
		return getService(cla.getAnnotation(Service.class).value(),cla);
	}
	public static Object getService(String name){
		return getSpringContext().getBean(name);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getService(String name,Class<?> cla){
		return ((T) getSpringContext().getBean(name, cla));
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context = arg0;
	}
}
