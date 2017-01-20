package com.base.utils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 时间处理
 * 
 * @author hujiang
 * @time 2015年9月1日15:34:21
 */
public class TimeUtils {

	public static final int MS_PER_MIN = 60 * 1000;
	public static final int MS_PER_HOUR = 60 * MS_PER_MIN;
	public static final int MS_PER_DAY = 24 * MS_PER_HOUR;

	private static long creationStamp;

	static {
		creationStamp = new Date().getTime();
	}

	public static long getStamp() {
		return new Date().getTime() - creationStamp;
	}

	/**
	 * 返回年月日，时分秒 格式为：2015-09-01 16:48:40
	 * 
	 * @return 返回字符串：格式为：2015-09-01 16:48:40
	 * @date 2015年9月1日 下午4:50:24
	 */
	public static String getDateTime() {
		return getDateTime(Calendar.getInstance());
	}

	/**
	 * 给定日期对象，返回日期字符串
	 * 
	 * @param calendar
	 *            日期对象
	 * @return 日期字符串：格式为：格式为：2015-09-01 16:48:40
	 * @date 2015年9月1日 下午4:52:01
	 */
	public static String getDateTime(Calendar calendar) {
		return getDateTime(calendar, "-");
	}

	/**
	 * 给定日期对象，日期连接符，返回日期字符串
	 * 
	 * @param calendar
	 *            日期对象
	 * @param dateSeparator
	 *            年月日，连接字符串 eg:"/" 、" -"
	 * @return 日期字符串
	 * @date 2015年9月1日 下午4:53:52
	 */
	public static String getDateTime(Calendar calendar, String dateSeparator) {
		return getDateTime(calendar, dateSeparator, ":");
	}

	/**
	 * 给定日期对象，日期连接符，时间连接符
	 * 
	 * @param calendar
	 *            日期对象
	 * @param dateSeparator
	 *            日期连接符
	 * @param timeSeparator
	 *            时间连接符
	 * @return 日期字符串
	 * @date 2015年9月1日 下午4:58:31
	 */
	public static String getDateTime(Calendar calendar, String dateSeparator, String timeSeparator) {
		return getDateTime(calendar, dateSeparator, timeSeparator, " ");
	}

	/**
	 * 给定日期对象，日期连接符，时间连接符，日期与时间连接符
	 * 
	 * @param calendar
	 *            日期对象
	 * @param dateSeparator
	 *            日期连接符
	 * @param timeSeparator
	 *            时间连接符
	 * @param datetimeSeparator
	 *            日期时间连接符
	 * @return 日期字符串
	 * @date 2015年9月1日 下午4:59:55
	 */
	public static String getDateTime(Calendar calendar, String dateSeparator, String timeSeparator,
			String datetimeSeparator) {
		return getDate(calendar, dateSeparator) + datetimeSeparator + getTime(calendar, timeSeparator);
	}

	/**
	 * 获取系统的日期
	 * 
	 * @return 返回日期字符串，格式为：2015-09-01
	 * @author hujiang
	 * @date 2015年9月1日 下午5:02:59
	 */
	public static String getDate() {
		return getDate(Calendar.getInstance());
	}

	/**
	 * 指定日历对象，返回日期
	 * 
	 * @param calendar
	 *            日历对象
	 * @return 日期字符串，格式为：2015-09-01
	 * @date 2015年9月1日 下午5:04:03
	 */
	public static String getDate(Calendar calendar) {
		return getDate(calendar, "-");
	}

	/**
	 * 指定日历对象，返回日期
	 * 
	 * @param calendar
	 *            日历对象
	 * @param separator
	 *            连接符
	 * @return 日期字符串，格式为：2015-09-01
	 * @date 2015年9月1日 下午5:05:44
	 */
	public static String getDate(Calendar calendar, String separator) {
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int date = calendar.get(Calendar.DATE);
		StringBuilder sb = new StringBuilder();
		sb.append(year);
		sb.append(separator);
		if (month < 10) {
			sb.append(0);
		}
		sb.append(month);
		sb.append(separator);
		if (date < 10) {
			sb.append(0);
		}
		sb.append(date);
		return sb.toString();
	}

	/**
	 * 返回短时间字符串
	 * 
	 * @return 返回短时间字符串 ，格式为：17:10:58
	 * @date 2015年9月1日 下午5:07:27
	 */
	public static String getTime() {
		return getTime(Calendar.getInstance());
	}

	/**
	 * 指定日历对象，返回短时间字符串
	 * 
	 * @param calendar
	 *            日历对象
	 * @return 返回短时间字符串 ，格式为：17:10:58
	 * @date 2015年9月1日 下午5:11:47
	 */
	public static String getTime(Calendar calendar) {
		return getTime(calendar, ":");
	}

	/**
	 * 指定日历对象，短时间连接字符，返回短时间字符串
	 * 
	 * @param calendar
	 *            日历对象
	 * @param separator
	 *            短时间连接字符
	 * @return 短时间字符串
	 * @date 2015年9月1日 下午5:12:20
	 */
	public static String getTime(Calendar calendar, String separator) {
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		StringBuilder sb = new StringBuilder();
		if (hour < 10) {
			sb.append(0);
		}
		sb.append(hour);
		sb.append(separator);
		if (minute < 10) {
			sb.append(0);
		}
		sb.append(minute);
		sb.append(separator);
		if (second < 10) {
			sb.append(0);
		}
		sb.append(second);
		return sb.toString();
	}

	/**
	 * 将日期类型的字符串转换为日历对象
	 * 
	 * @param input
	 *            日期格式的字符串
	 * @return 日期对象
	 * @date 2015年9月1日 下午5:13:48
	 */
	public static Calendar parse(String input) {
		Calendar calendar = null;
		input = input.replaceAll("\\D", "");
		if (input.length() == 14) {
			int year = parseInt(input.substring(0, 4));
			int month = parseInt(input.substring(4, 6)) - 1;
			int day = parseInt(input.substring(6, 8));
			int hour = parseInt(input.substring(8, 10));
			int minute = parseInt(input.substring(10, 12));
			int second = parseInt(input.substring(12));
			calendar = Calendar.getInstance();
			calendar.set(year, month, day, hour, minute, second);
		}
		return calendar;
	}

	private static Integer parseInt(String input) {
		Integer i = null;
		try {
			i = Integer.parseInt(input);
		} catch (Exception e) {
		}
		return i;
	}

	/**
	 * 将秒转换成多长时间，60 = 1分0秒
	 * 
	 * @param seconds
	 *            秒
	 * @return 多长时间
	 * @date 2015年9月1日 下午5:17:16
	 */
	public static String getLength(long seconds) {
		long hour = seconds / 3600;
		long left = seconds - hour * 3600;
		long minute = left / 60;
		long second = left - minute * 60;
		StringBuilder sb = new StringBuilder();
		if (hour > 0) {
			sb.append(hour);
			sb.append("时");
		}
		if (minute > 0) {
			sb.append(minute);
			sb.append("分");
		}
		sb.append(second);
		sb.append("秒");
		return sb.toString();
	}
	/**
	 * 一个星期中的第几天
	 * @param date
	 * @return
	 * @date 2015年9月2日 上午10:58:32
	 */
	public static int getDayOfWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek;
	}
	/**
	 * 一年中的第几天
	 * @param date
	 * @return
	 * @date 2015年9月2日 上午10:59:17
	 */
	public static int getDayOfYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_YEAR);
		return dayOfWeek;
	}

	/**
	 * 一个月中的第几个星期
	 * @param date
	 * @return
	 * @date 2015年9月2日 上午10:59:32
	 */
	public static int getWeekOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.WEEK_OF_MONTH);
		return dayOfWeek;
	}
	
	/**
	 * 一年中的第几个星期
	 * @param date
	 * @return
	 * @date 2015年9月2日 上午11:00:16
	 */
	public static int getWeekOfYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.WEEK_OF_YEAR);
		return dayOfWeek;
	}
	
	/**
	 * 指定时间，得到本周一的时间
	 * @param date
	 * @return
	 * @date 2015年9月2日 上午11:00:27
	 */
	public static String getMondayDate(Date date)
	{
		SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
		return dateFormat.format(calendar.getTime());
		
	}
	
	/**
	 * 指定时间，得到本周日的时间
	 * @param date
	 * @return
	 * @date 2015年9月2日 上午11:00:45
	 */
	public static String getSundayDate(Date date)
	{
		SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
		return dateFormat.format(calendar.getTime());
	}

}
