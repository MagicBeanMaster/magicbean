package com.base.utils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class MemoryUtils {
	private static final long MEMORY = 1 * 1024*1024;
	private static final Lock lock=new ReentrantLock();
	
	/**
	 * 
	 * @description 判断Map值的大小添加数值 
	 * @param key 键
	 * @param obj 值
	 * @param map
	 * @return
	 * @date 2015年12月14日 下午8:06:19
	 */
	public static boolean add(String key,Object obj,Map<String,Object> map){
		boolean flag=true;
		long freeMemory = Runtime.getRuntime().freeMemory();
		if(freeMemory > MEMORY){
			lock.lock();
			try {
				map.put(key, obj);
			}finally {
				lock.unlock();
			}
		}else{
			flag=false;
		}
		return flag;
	}
	
	/**
	 * 
	 * @description 判断list值的大小 
	 * @param obj 对象
	 * @param list List对象
	 * @return
	 * @date 2015年12月14日 下午8:07:06
	 */
	public static boolean add(Object obj,List<Object> list){
		boolean flag=true;
		long freeMemory = Runtime.getRuntime().freeMemory();
		if(freeMemory > MEMORY){
			lock.lock();
			try {
				list.add(obj);
			}finally {
				lock.unlock();
			}
		}else{
			flag=false;
		}
		return flag;
	}
	
}
