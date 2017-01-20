package com.base.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class DateUtils {
	public static String getDateStr(Date d,String formate){
		SimpleDateFormat sdf = new SimpleDateFormat(formate);
		return sdf.format(d);
	}
	
	public static String getSysDateStr(String formate){
		SimpleDateFormat sdf = new SimpleDateFormat(formate);
		return sdf.format(new Date());
	}
	
	/**
	 * 
	 * @description 获取当前的timestamp 
	 * @return
	 * @date 2015年10月28日 下午3:20:01
	 */
	public static Timestamp getTimestamp(){
		return new Timestamp(System.currentTimeMillis());
	}
	
	
	/**
	 * 
	 * @description 与当前时间比较 
	 * @param time
	 * @param minute
	 * @return
	 * @author lq
	 * @date 2016年5月4日 上午10:29:33
	 */
	public static boolean compareTime(Timestamp time,int minute){
		Timestamp temp = new Timestamp(time.getTime());
		long currtime = System.currentTimeMillis();
		temp.setMinutes(time.getMinutes()+minute);
		if(currtime >= temp.getTime()){
			return true;
		}
		return false;
	}

	/**
	 * 获取指定时间对应的毫秒数
	 * @param time "HH:mm:ss"
	 * @return
	 */
	public static long getTimeMillis(String time) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
			DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");
			Date curDate = dateFormat.parse(dayFormat.format(new Date()) + " " + time);
			return curDate.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
}
