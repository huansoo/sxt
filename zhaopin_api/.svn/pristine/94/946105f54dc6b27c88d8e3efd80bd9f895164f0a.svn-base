package com.wugu.zhaopin.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
* @ClassName: DateUtil
* @Description: 日期时间转换类
* @author lijun
* @date 2013-12-25 下午4:49:14
*
 */
public class DateUtil {
	//protected final static Log _log = LogFactory.getLog(DateUtil.class);
	private static SimpleDateFormat dateformater;
	
	static java.text.SimpleDateFormat sdfShort = new java.text.SimpleDateFormat(
	"yyyyMMdd");
	static java.text.SimpleDateFormat sdfLong = new java.text.SimpleDateFormat(
	"yyyy-MM-dd");
	static java.text.SimpleDateFormat sdfLongTime = new java.text.SimpleDateFormat(
	"yyyyMMddHHmmss");
	static java.text.SimpleDateFormat sdfLongTimePlus = new java.text.SimpleDateFormat(
	"yyyy-MM-dd HH:mm:ss");
	static java.text.SimpleDateFormat sdfLongTimePlusMill = new java.text.SimpleDateFormat(
	"yyyyMMddHHmmssSSSS");
	private static long DAY_IN_MILLISECOND = 0x5265c00L;
	
	/**
	 * 
	* @Title: DateToStr
	* @Description: 日期对象转换成字符串
	* @author lijun
	* @param date 日期对象
	* @param format 日期格式
	* @return 转换后的日期字符串
	* @throws
	 */
	public static String DateToStr(Date date, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		} catch (Exception e) {
    		System.out.println("Date 转 String 类型失败: " + e);
			return null;
		}
	}
	
	
	/**
	 * 
	* @Title: parseDate
	* @Description: 把字符型日期表达式转换成
	* @author lijun
	* @param strDate 如 "yyyy-M-dd" 的日期字符串
	* @return 转换后的日期对象
	* @throws
	 */
	public Date parseDate(String strDate) {
		Date date = null;
		try {
			date = getDateFormater().parse(strDate);
		} catch (Exception ex) {
			//  System.err.println(ex.getMessage());
		}
		return date;
	}
	
	
	
	private DateFormat getDateFormater() {
		if (dateformater == null)
			dateformater = new SimpleDateFormat("yyyy-M-dd");
		return dateformater;
	}
	
	/**
	 * 
	* @Title: dateAddDays
	* @Description: 增加天数
	* @author lijun
	* @param date 基础日期
	* @param days 增加的天数
	* @return 增加天数后的日期
	* @throws
	 */
	public static Date dateAddDays(Date date, int days) {
		long now = date.getTime() + (long) days * DAY_IN_MILLISECOND;
		return new Date(now);
	}
	
	public static String getDate(){
		Date date=new Date();
		DateFormat df=new SimpleDateFormat("yyyyMMdd");
		return df.format(date);
	}
	
	public static void main(String[] args){
		/*Date dd=new Date();
		String d=DateUtil.dateTypeToString(dd, "yyyy-MM-dd HH:mm:ss");
		System.out.println("tiem "+d);*/
		
		String nowDateString=getStringOfNowDate("yyyy-MM-dd");
		DateUtil d=new DateUtil();
		Date dd=d.parseDate(nowDateString);
		System.out.println("string to date " +dateTypeToString(dd,"yyyy-MM-dd"));
		String s=dateTypeToString(dateAddDays(dd,1),"yyyy-MM-dd");
		System.out.println("string to date +1   " +s);
		
		/*System.out.println("当天:" + nowDateString+"-----"+getDateOfFirstDayInMonth());
		String firstDayInMoth=getStringOfFirstDayInMonth();
		System.out.println("该月第一天:" + firstDayInMoth);*/
		
		
		Date sa = strDateConvertToDate("2010-02-11 19:40:01","yyyy-MM-dd HH:mm:ss");
		System.out.println("aa"+DateToStr(sa,"yyyy-MM-dd HH:mm:ss"));
		
		
		
	}
	
	/**
	 * 
	* @Title: dateTypeToString
	* @Description: 转换成字符性日期格式
	* @author lijun
	* @param date 日期
	* @param fFormatStr 时间格式，如:yyyy-MM-dd HH:mm:ss
	* @return
	* @throws
	 */
	public static String dateTypeToString(Date date,String fFormatStr){
		//yyyy-MM-dd HH:mm:ss
		SimpleDateFormat dateformat=new SimpleDateFormat(fFormatStr);
		String strDate=dateformat.format(date);
		return strDate;
	}
	
	/**
	 * 
	* @Title: getStringOfNowDate
	* @Description: 获取当前的系统时间，并按照固定的格式初始化
	* @author lijun
	* @param fFormatStr 时间格式，如yyyy-MM-dd
	* @return 当前的系统时间
	* @throws
	 */
	public static String getStringOfNowDate(String fFormatStr){
		String nowDateString=dateTypeToString(new Date(),fFormatStr);
		return nowDateString;
	}
	
	/**
	 * 
	* @Title: getDateOfNowDate
	* @Description: 获取当前的系统时间，并按照固定的格式初始化
	* @author lijun
	* @param fFormatStr 时间格式，如yyyy-MM-dd
	* @return 当前的系统时间
	* @throws
	 */
	public static Date getDateOfNowDate(String fFormatStr){
		String nowDateString=dateTypeToString(new Date(),fFormatStr);
		return new DateUtil().parseDate(nowDateString);
	}
	
    /**
     * 
    * @Title: getStringOfFirstDayInMonth
    * @Description: 获取当月的第一天,以字符串方式返回
    * @author lijun
    * @return 当月的第一天，2009-05-01
    * @throws
     */
	public static String getStringOfFirstDayInMonth() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String temp = sdf.format(date);
		String firstDayInMoth = "";
		firstDayInMoth = temp + "-01";
		
		return firstDayInMoth;

	}
	
	/**
	 * 
	* @Title: getDateOfFirstDayInMonth
	* @Description: 获取当月的第一天，以日期类型返回
	* @author lijun
	* @return 当月的第一天，2009-05-01
	* @throws
	 */
	public static Date getDateOfFirstDayInMonth() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String temp = sdf.format(date);
		String firstDayInMoth = "";
		firstDayInMoth = temp + "-01";
		
		return new DateUtil().parseDate(firstDayInMoth);

	}	
	
	/**
	 * 
	* @Title: getPlusTime2
	* @Description: 取得当前日期,以字符串形式返回
	* @author lijun
	* @param date
	* @return 当前日期 格式为:yyyy-MM-dd HH:mm:ss
	* @throws
	 */
	public static String getPlusTime2(Date date)
	{
		
		if(date == null ) return null;
		try
		{
			String nowDate = sdfLongTimePlus.format(date);
			return nowDate;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 
	* @Title: getNowTimeStr
	* @Description: 获取当前时间，并以字符串形式返回
	* @author lijun
	* @return 当前日期 格式为:yyyy-MM-dd HH:mm:ss
	* @throws
	 */
	public static String getNowTimeStr(){
	    return getPlusTime2(new Date());
	}
	

	/**
	 * 
	* @Title: strDateConvertToDate
	* @Description: 字符串形式日期装换成date
	* @author lijun
	* @param strDate 
	* @param fFormatStr eg :yyyy-MM-dd HH:mm:ss
	* @return 字符串形式日期装换成date类型
	* @throws
	 */
	public static Date strDateConvertToDate(String strDate,String fFormatStr){
		java.util.Date birthday = new java.util.Date();
		java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat(fFormatStr);
        try {
			birthday = sdf.parse(strDate);
			return birthday;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}	
	
	/**
	 * 
	* @Title: getCurrentTimes
	* @Description: 以秒位单位返回自1970年1月1日凌晨到现在的时间
	* @author lijun
	* @return
	* @throws
	 */
	public static int getCurrentTimes(){		
		Long c = System.currentTimeMillis() / 1000; 
		
		return c.intValue();		
	}
}
