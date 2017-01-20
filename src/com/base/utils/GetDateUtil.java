package com.base.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**	
 * 
 * @description 获取各种时间组件 
 * @author xubin
 * @date 2016年1月9日 下午5:51:55 
 * @version
 */
public class GetDateUtil {
	/**
	 * 
	 * @description 本年开始时间
	 * @return
	 * @date 2016年1月9日 下午5:51:00
	 */
	public static long FromYear() {
		Calendar nowDate = new java.util.GregorianCalendar();
		nowDate.set(Calendar.HOUR_OF_DAY, 0);
		nowDate.set(Calendar.MINUTE, 0);
		nowDate.set(Calendar.SECOND, 0);
		nowDate.set(Calendar.MILLISECOND, 0);
		nowDate.set(Calendar.DAY_OF_MONTH, 1);
		nowDate.set(Calendar.MONTH, 0);
		return nowDate.getTimeInMillis() / 1000;
	}

	/**
	 * 
	 * @description 本年结束时间
	 * @return
	 * @date 2016年1月9日 下午5:51:00
	 */
	public static long ToYear() {
		Calendar nowDate = new java.util.GregorianCalendar();
		nowDate.set(Calendar.HOUR_OF_DAY, 0);
		nowDate.set(Calendar.MINUTE, 0);
		nowDate.set(Calendar.SECOND, 0);
		nowDate.set(Calendar.MILLISECOND, -1);
		nowDate.set(Calendar.DAY_OF_MONTH, 1);
		nowDate.set(Calendar.MONTH, 12);
		return nowDate.getTimeInMillis() / 1000;
	}

	/**
	 * 
	 * @description 获取 本月开始时间
	 * @return
	 * @date 2016年1月9日 下午5:49:29
	 */
	public static long FromMonth() {
		Calendar nowDate = new java.util.GregorianCalendar();
		nowDate.set(Calendar.HOUR_OF_DAY, 0);
		nowDate.set(Calendar.MINUTE, 0);
		nowDate.set(Calendar.SECOND, 0);
		nowDate.set(Calendar.MILLISECOND, 0);
		nowDate.set(Calendar.DAY_OF_MONTH, 1);
		return nowDate.getTimeInMillis() / 1000;
	}

	/**
	 * 
	 * @description 获取 本月结束时间
	 * @return
	 * @date 2016年1月9日 下午5:49:29
	 */
	public static long ToMonth() {
		Calendar nowDate = new java.util.GregorianCalendar();
		nowDate.set(Calendar.HOUR_OF_DAY, 0);
		nowDate.set(Calendar.MINUTE, 0);
		nowDate.set(Calendar.SECOND, 0);
		nowDate.set(Calendar.MILLISECOND, -1);
		nowDate.set(Calendar.DAY_OF_MONTH, 1);
		nowDate.add(Calendar.MONTH, 1);
		return nowDate.getTimeInMillis() / 1000;
	}

	/**
	 * 
	 * @description 自定义本月
	 * @return
	 * @date 2015年12月17日 下午6:47:32
	 */
	public static long FromMonth(Date date) {
		Calendar nowDate = Calendar.getInstance();
		nowDate.setTime(date);
		nowDate.set(Calendar.HOUR_OF_DAY, 0);
		nowDate.set(Calendar.MINUTE, 0);
		nowDate.set(Calendar.SECOND, 0);
		nowDate.set(Calendar.MILLISECOND, 0);
		nowDate.set(Calendar.DAY_OF_MONTH, 1);
		return nowDate.getTimeInMillis() / 1000;
	}

	/**
	 * 
	 * @description 自定义本月
	 * @return
	 * @date 2015年12月17日 下午6:47:32
	 */
	public static long ToMonth(Date date) {
		Calendar nowDate = Calendar.getInstance();
		nowDate.setTime(date);
		nowDate.set(Calendar.HOUR_OF_DAY, 0);
		nowDate.set(Calendar.MINUTE, 0);
		nowDate.set(Calendar.SECOND, 0);
		nowDate.set(Calendar.MILLISECOND, -1);
		nowDate.set(Calendar.DAY_OF_MONTH, 1);
		nowDate.add(Calendar.MONTH, 1);
		return nowDate.getTimeInMillis() / 1000;
	}

	/**
	 * 
	 * @description 获取进三个月 当前开始时间
	 * @return
	 * @date 2016年1月9日 下午5:50:19
	 */
	public static long ToSystemDate() {
		Calendar rightNow = Calendar.getInstance();
		rightNow.get(Calendar.YEAR);
		rightNow.get(Calendar.MONTH);
		rightNow.get(Calendar.DAY_OF_MONTH);
		rightNow.get(Calendar.HOUR_OF_DAY);
		rightNow.get(Calendar.MINUTE);
		rightNow.get(Calendar.SECOND);
		return rightNow.getTimeInMillis() / 1000;
	}

	/**
	 * 
	 * @description 获取进三个月 后退3个月时间
	 * @return
	 * @date 2016年1月9日 下午5:50:19
	 */
	public static long ToThreeMonth() {
		Date date = new Date();// your date
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, -3);// 前推3天的日期
		return cal.getTimeInMillis() / 1000;
	}

	/**
	 * 
	 * @description 自定义 时间范围（近几个月）
	 * @return
	 * @date 2015年12月17日 下午6:08:46
	 */
	public static long ToThreeMonth(Date date, int mork) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, mork);// 前推3天的日期
		return cal.getTimeInMillis() / 1000;
	}

	/**
	 * 
	 * @description 获取 本周开始时间
	 * @return
	 * @date 2016年1月9日 下午5:49:29
	 */
	public static long FromWeek() {
		Calendar nowDate = new java.util.GregorianCalendar();
		nowDate.set(Calendar.HOUR_OF_DAY, 0);
		nowDate.set(Calendar.MINUTE, 0);
		nowDate.set(Calendar.SECOND, 0);
		nowDate.set(Calendar.MILLISECOND, 0);
		nowDate.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return nowDate.getTimeInMillis() / 1000;
	}

	/**
	 * 
	 * @description 获取 本周结束时间
	 * @return
	 * @date 2016年1月9日 下午5:49:29
	 */
	public static long ToWeek() {
		Calendar nowDate = new java.util.GregorianCalendar();
		nowDate.set(Calendar.HOUR_OF_DAY, 0);
		nowDate.set(Calendar.MINUTE, 0);
		nowDate.set(Calendar.SECOND, 0);
		nowDate.set(Calendar.MILLISECOND, -1);
		nowDate.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		nowDate.add(Calendar.WEEK_OF_MONTH, 1);
		return nowDate.getTimeInMillis() / 1000;
	}

	/**
	 * 
	 * @description 获取 昨天开始时间
	 * @return
	 * @date 2016年1月9日 下午5:48:49
	 */

	public static long FromYesterday() {
		Calendar nowDate = new java.util.GregorianCalendar();
		nowDate.set(Calendar.HOUR_OF_DAY, 0);
		nowDate.set(Calendar.MINUTE, 0);
		nowDate.set(Calendar.SECOND, 0);
		nowDate.set(Calendar.MILLISECOND, 0);
		nowDate.add(Calendar.DAY_OF_MONTH, -1);
		return nowDate.getTimeInMillis() / 1000;
	}

	/**
	 * 
	 * @description 获取 昨天结束时间
	 * @return
	 * @date 2016年1月9日 下午5:49:11
	 */

	public static long ToYesterday() {
		Calendar nowDate = new java.util.GregorianCalendar();
		nowDate.set(Calendar.HOUR_OF_DAY, 0);
		nowDate.set(Calendar.MINUTE, 0);
		nowDate.set(Calendar.SECOND, 0);
		nowDate.set(Calendar.MILLISECOND, -1);
		return nowDate.getTimeInMillis() / 1000;
	}

	/**
	 * 
	 * @description 获取 当天开始时间
	 * @return
	 * @date 2016年1月9日 下午5:47:19
	 */
	public static long FromToday() {
		Calendar nowDate = new java.util.GregorianCalendar();
		nowDate.set(Calendar.HOUR_OF_DAY, 0);
		nowDate.set(Calendar.MINUTE, 0);
		nowDate.set(Calendar.SECOND, 0);
		nowDate.set(Calendar.MILLISECOND, 0);
		return nowDate.getTimeInMillis() / 1000;
	}

	/**
	 * 
	 * @description 获取 当天结束时间
	 * @return
	 * @date 2016年1月9日 下午5:47:43
	 */

	public static long ToToday() {
		Calendar nowDate = new java.util.GregorianCalendar();
		nowDate.set(Calendar.HOUR_OF_DAY, 0);
		nowDate.set(Calendar.MINUTE, 0);
		nowDate.set(Calendar.SECOND, 0);
		nowDate.set(Calendar.MILLISECOND, -1);
		nowDate.add(Calendar.DAY_OF_MONTH, 1);
		return nowDate.getTimeInMillis() / 1000;
	}

	/**
	 * startDate 格式 2009-02-03 startTime 格式 12:20
	 */
	public static long FromTime(String startDate, String startTime) {
		Calendar nowDate = new java.util.GregorianCalendar();
		long fromtime = 0;
		if (!startDate.equals("")) {
			String[] s = startDate.split("-");
			nowDate = new java.util.GregorianCalendar();
			nowDate.set(Calendar.DAY_OF_MONTH, Integer.parseInt(s[2]));
			nowDate.set(Calendar.MONTH, Integer.parseInt(s[1]) - 1);
			nowDate.set(Calendar.YEAR, Integer.parseInt(s[0]));

			String[] t = startTime.split(":");
			nowDate.set(Calendar.HOUR_OF_DAY, Integer.parseInt(t[0]));
			nowDate.set(Calendar.MINUTE, Integer.parseInt(t[1]));
			nowDate.set(Calendar.SECOND, 0);
			fromtime = nowDate.getTimeInMillis() / 1000;
		}
		return fromtime;
	}

	/**
	 * endDate 格式 2009-02-03 endTime 格式 12:20
	 */
	public static long ToTime(String endDate, String endTime) {
		Calendar nowDate = new java.util.GregorianCalendar();
		long totime = 0;
		if (!endDate.equals("")) {
			String[] s = endDate.split("-");
			nowDate = new java.util.GregorianCalendar();
			nowDate.set(Calendar.DAY_OF_MONTH, Integer.parseInt(s[2]));
			nowDate.set(Calendar.MONTH, Integer.parseInt(s[1]) - 1);
			nowDate.set(Calendar.YEAR, Integer.parseInt(s[0]));

			String[] t = endTime.split(":");
			nowDate.set(Calendar.HOUR_OF_DAY, Integer.parseInt(t[0]));
			nowDate.set(Calendar.MINUTE, Integer.parseInt(t[1]));
			nowDate.set(Calendar.SECOND, 0);
			totime = nowDate.getTimeInMillis() / 1000;
		}
		return totime;
	}

	// 格式化时间戳，参数为秒，不需要乘以1000
	public static String FormatTimeStamp(String pattern, long date) {
		if (pattern.length() == 0)
			pattern = "yyyy-MM-dd HH:mm:ss";
		java.util.Calendar nowDate = new java.util.GregorianCalendar();
		nowDate.setTimeInMillis(date * 1000);
		DateFormat df = new SimpleDateFormat(pattern);
		return df.format(nowDate.getTime());
	}
	
	/**
	 * @description 获取上月开始时间
	 * @return 格式化完成的字符串
	 * @date 2016年4月27日 下午5:57:13 
	 */
	public static String startLastMonth(){
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(new Date());
//		calendar.set(Calendar.HOUR_OF_DAY, 0);
//		calendar.set(Calendar.MINUTE, 0);
//		calendar.set(Calendar.SECOND, 0);
//		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		
		Calendar nowDate = Calendar.getInstance();
		nowDate.add(Calendar.MONTH, -1);
		nowDate.set(Calendar.HOUR_OF_DAY, 0);
		nowDate.set(Calendar.MINUTE, 0);
		nowDate.set(Calendar.SECOND, 0);
		nowDate.set(Calendar.MILLISECOND, 0);
		nowDate.set(Calendar.DAY_OF_MONTH, 1);
		return FormatTimeStamp("",nowDate.getTime().getTime()/1000);
	}
	
	/**
	 * @description 获取上月最后一天时间
	 * @return
	 * @date 2016年4月27日 下午5:59:15 
	 */
	public static String endLastMonth(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return FormatTimeStamp("",calendar.getTime().getTime()/1000);
	}
	
	/**
	 * @description 上周开始时间
	 * @return
	 * @date 2016年5月6日 上午9:29:15 
	 */
	public static String startLastWeek(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.WEEK_OF_YEAR, -1);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return GetDateUtil.FormatTimeStamp("yyyy-MM-dd HH:mm:ss",calendar.getTimeInMillis() / 1000);
	}
	
	/**
	 * @description 上周结束时间
	 * @return
	 * @date 2016年5月6日 上午9:29:27 
	 */
	public static String endLastWeek(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.WEEK_OF_YEAR, -1);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		calendar.add(Calendar.DATE, 6);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return GetDateUtil.FormatTimeStamp("yyyy-MM-dd HH:mm:ss",calendar.getTimeInMillis() / 1000);
	}
	
	/**
	 * @description 格式化开始时间
	 * @param date
	 * @return
	 * @throws ParseException 
	 * @date 2016年5月6日 上午9:40:11 
	 */
	public static String formatStartDate(String dateStr) throws ParseException{
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(dateStr);
		Calendar nowDate = Calendar.getInstance();
		nowDate.setTime(date);
		nowDate.set(Calendar.HOUR_OF_DAY, 0);
		nowDate.set(Calendar.MINUTE, 0);
		nowDate.set(Calendar.SECOND, 0);
		return GetDateUtil.FormatTimeStamp("",nowDate.getTimeInMillis() / 1000);
	}
	/**
	 * @description 格式化结束时间
	 * @param date
	 * @return
	 * @throws ParseException 
	 * @date 2016年5月6日 上午9:40:03 
	 */
	public static String formatEndDate(String dateStr) throws ParseException{
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(dateStr);
		Calendar nowDate = Calendar.getInstance();
		nowDate.setTime(date);
		nowDate.set(Calendar.HOUR_OF_DAY, 23);
		nowDate.set(Calendar.MINUTE, 59);
		nowDate.set(Calendar.SECOND, 59);
		return GetDateUtil.FormatTimeStamp("",nowDate.getTimeInMillis() / 1000);
	}
	

	public static void main(String args[]) {
		System.out.println("今天:");
		System.out.println(FormatTimeStamp("", FromToday()) + "---" + FormatTimeStamp("", ToToday()));
		System.out.println("昨天:");
		System.out.println(FormatTimeStamp("", FromYesterday()) + "---" + FormatTimeStamp("", ToYesterday()));
		System.out.println("本周:");
		System.out.println(FormatTimeStamp("", FromWeek()) + "---" + FormatTimeStamp("", ToWeek()));
		System.out.println("本月:");
		System.out.println(FormatTimeStamp("", FromMonth()) + "---" + FormatTimeStamp("", ToMonth()));
		System.out.println("近三月:");
		System.out.println(FormatTimeStamp("", ToSystemDate()) + "---" + FormatTimeStamp("", ToThreeMonth()));
		System.out.println("本年:");
		System.out.println(FormatTimeStamp("", FromYear()) + "---" + FormatTimeStamp("", ToYear()));
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date s = dateFormat.parse("2015-12-02 10:01:20");
			System.out.println(FormatTimeStamp("", FromMonth(s)) + "---" + FormatTimeStamp("", ToMonth(s)));
		} catch (ParseException e) {
			ExceptionUtils.dealException(e);
		}
	}
	
	/**
	 * @description 自定义时间查询开始
	 * @param datestart
	 * @return
	 * @date 2016年5月6日 上午9:40:11 
	 */
	public static Date startDateReset(Date datestart) {
		Calendar nowDate = Calendar.getInstance();
		nowDate.setTime(datestart);
		nowDate.set(Calendar.HOUR_OF_DAY, 0);
		nowDate.set(Calendar.MINUTE, 0);
		nowDate.set(Calendar.SECOND, 0);
		return new Date(nowDate.getTimeInMillis());
	}
	
	
	/**
	 * @description 自定义时间查询结束
	 * @param datesend
	 * @return
	 * @date 2016年5月6日 上午9:40:11 
	 */
	public static Date endDateReset(Date datesend) {
		Calendar nowDate = Calendar.getInstance();
		nowDate.setTime(datesend);
		nowDate.set(Calendar.HOUR_OF_DAY, 23);
		nowDate.set(Calendar.MINUTE, 59);
		nowDate.set(Calendar.SECOND, 59);
		return new Date(nowDate.getTimeInMillis());
	}
}