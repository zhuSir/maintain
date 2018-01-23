package com.xmsmartcity.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author sumory.wu
 * @date 2011-9-17 上午12:23:15
 * @version 2.0
 */
public class DateUtils {

    public final static String formatStr_yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
    public final static String formatStr_yyyyMMddHHmm = "yyyy-MM-dd HH:mm";
    public final static String formatStr_yyyyMMddHH = "yyyy-MM-dd HH";
    public final static String formatStr_yyyyMMdd = "yyyy-MM-dd";
    public final static String formatStr_yyyyMM = "yyyy-MM";
    public final static String formatStr_yyyy年MM月dd日HHmm = "yyyy年MM月dd日 HH:mm";
    public final static String formatStr_yyyymmdd = "yyyy.MM.dd";
	public final static String formatStr_MMdd_EE_HHmm = "MM/dd EEEE HH:mm";
	public final static String formatStr_HHmm = "HH:mm";
	public final static String formatStr_MMdd = "MM/dd";
	public final static String formatStr_MMdd2 = "MM月dd日";
	public final static String formatStr_MMddHHmm = "MM-dd HH:mm";
	public final static String formatStr_HHmmss = "HH:mm:ss";
	

    public static String DateToString(long timestamp, String toFormatStr) {
        try {
            return new SimpleDateFormat(toFormatStr).format(timestamp);
        }
        catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String DateToString(Date date, String toFormatStr) {
        try {
            return new SimpleDateFormat(toFormatStr).format(date);
        }
        catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String DateToString(java.sql.Date date, String toFormatStr) {
        try {
            return new SimpleDateFormat(toFormatStr).format(date);
        }
        catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Date StringToDate(String dateString, String strFormat) {
        try {
            Date date = new SimpleDateFormat(strFormat).parse(dateString);
            return date;
        }
        catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    

    
    public static java.sql.Timestamp stringToTimestamp(String dateString, String strFormat) {
        return new java.sql.Timestamp(StringToDate(dateString,strFormat).getTime());
    }
    
    public static java.sql.Timestamp stringToTimestampAddDays(String dateString, String strFormat,int days) {
        return new java.sql.Timestamp(StringToDate(dateString,strFormat).getTime() + days*1000*60*60*24);
    }


    public static java.sql.Date toSQLDate(Date date) {
        return new java.sql.Date(date.getTime());
    }

    public static java.sql.Timestamp toTimestamp(Date date) {
        return new java.sql.Timestamp(date.getTime());
    }

    public static java.sql.Timestamp toTimestamp(java.sql.Date date) {
        return new java.sql.Timestamp(date.getTime());
    }

    public static Date toUtilDate(java.sql.Date date) {
        return new Date(date.getTime());
    }

    /**
     * 得到几天前的时间
     * 
     * @param day
     * @return
     */
    public static String getSomeDate(int day) {
        try {
            Calendar date = Calendar.getInstance();
            date.add(Calendar.DATE, -day);// 向前推day
            return DateToString(date.getTime(), "yyyy-MM-dd");
        }
        catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }
	
	/**
	 * 选择两个时间中较大的一个
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static String getMaxDate(String date1, String date2){
		Date comDate1 = StringToDate(date1, formatStr_yyyyMMdd);
		Date comDate2 = StringToDate(date2, formatStr_yyyyMMdd);
		if(comDate1.after(comDate2)){
			return date1;
		}else
			return date2;
	}
	
	/**
	 * 年份计算
	 * @param date
	 * @param year
	 * @return
	 */
	public static String getDateByYear(Date date, int year){
		try {
			Calendar cal=Calendar.getInstance();
			cal.setTime(date); 
            cal.add(Calendar.YEAR, year);//
            return DateToString(cal.getTime(), "yyyy-MM-dd");
        }
        catch (Exception e) {
            e.printStackTrace();
            return "";
        }
	}
	/**
	 * 得到后几天的时间
	 * 
	 * @author zhangjunhao 2014-10-30 下午1:53:49
	 * 
	 * @param day
	 * @return
	 */
	public static String getAfterDate(int day, String format) {
		try {
			Calendar date = Calendar.getInstance();
			date.add(Calendar.DATE, day);// 向后推day
			return DateToString(date.getTime(), format);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}

	/**
	 * 得到前几个小时的时间
	 * 
	 * @author zhangjunhao 2014-10-30 下午2:27:35
	 * 
	 * @param hour
	 * @return
	 */
	public static String getBeforeDate(Date date, int hour, String dateFormat) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.HOUR, -hour);// 向前推day
			return DateToString(c.getTime(), dateFormat);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}

	/**
	 * 得到当前时间
	 * 
	 * @author zhangjunhao 2014-10-30 下午1:55:01
	 * 
	 * @param dateFormat
	 *            自定义 yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getNowDate(String dateFormat) {
		try {
			Calendar date = Calendar.getInstance();
			return DateToString(date.getTime(), dateFormat);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}



	/**
	 * 比较时间
	 * 
	 * @author zhangjunhao 2014-10-30 下午2:40:48
	 * 
	 * @return
	 */
	public static boolean compareDate(Date date1, Date date2) {
		try {
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			c1.setTime(date1);
			c2.setTime(date2);
			// 如果比赛时间在他前两个小时前面
			//c2.add(Calendar.HOUR, -2);
			if (c1.before(c2)) {
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
	}

	/**
	 * 获得两个的时间差 （天）
	 * @author zhangjunhao 2014-11-7 上午11:05:20
	 *
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int getDateDifferent(Date d1, Date d2){
		try {
			Calendar aCalendar = Calendar.getInstance();
			aCalendar.setTime(d1);
			long day1=aCalendar.getTimeInMillis();
			aCalendar.setTime(d2);
			long day2=aCalendar.getTimeInMillis();
			return (int)((day2 - day1)/(1000 * 3600 * 24));
		} catch (Exception e) {
			return 0;
		}

	}
	/**
     * 获取某月的最后一天
     * @Title:getLastDayOfMonth
     * @Description:
     * @param:@param year
     * @param:@param month
     * @param:@return
     * @return:String
     * @throws
     */
    public static String getLastDayOfMonth(int year,int month)
    {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR,year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDayOfMonth = sdf.format(cal.getTime());
         
        return lastDayOfMonth;
    }
    /**
     * 获取某月的第一天
     * @Title:getFirstDayOfMonth
     * @Description:
     * @param:@param year
     * @param:@param month
     * @param:@return
     * @return:String
     * @throws
     */
    public static String getFirstDayOfMonth(int year,int month)
    {
    	Calendar cal = Calendar.getInstance();
    	//设置年份
    	cal.set(Calendar.YEAR,year);
    	//设置月份
    	cal.set(Calendar.MONTH, month-1);
    	//获取某月最大天数
    	int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
    	//设置日历中月份的最大天数
    	cal.set(Calendar.DAY_OF_MONTH, firstDay);
    	//格式化日期
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	String firstDayOfMonth = sdf.format(cal.getTime());
    	
    	return firstDayOfMonth;
    }
    
   
	public static void main(String[] args) {
	//	System.out.println(DateUtils.DateToString(new Date(), DateUtils.formatStr_HHmmaa));
		System.out.println(DateUtils.getFirstDayOfMonth(2014, 11));
	}
	
	/**
	 * 相差时间差（分钟）
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static long dateDiff(Date startTime, Date endTime) {
		long nd = 1000*24*60*60;//一天的毫秒数
		long nh = 1000*60*60;//一小时的毫秒数
		long nm = 1000*60;//一分钟的毫秒数
	/*	long ns = 1000;//一秒钟的毫秒数long diff;try {
*/		//获得两个时间的毫秒时间差异
		long diff = endTime.getTime() - startTime.getTime();
		long day = diff/nd;//计算差多少天
		long hour = diff%nd/nh;//计算差多少小时
		long min = diff%nd%nh/nm;//计算差多少分钟
	/*	long sec = diff%nd%nh%nm/ns;//计算差多少秒//输出结果
*/		//System.out.println("时间相差："+day+"天"+hour+"小时"+min+"分钟"+sec+"秒。");
		min = day * 24 *60 +hour*60+min;
		return min;
	}

	/**
	 * 相差时间差（分钟）
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static String dateDiff2(Date startTime, Date endTime) {
		long nd = 1000*24*60*60;//一天的毫秒数
		long nh = 1000*60*60;//一小时的毫秒数
		long nm = 1000*60;//一分钟的毫秒数
		long ns = 1000;//一秒钟的毫秒数long diff;try {
		//获得两个时间的毫秒时间差异
		long diff = endTime.getTime() - startTime.getTime();
		/*System.out.println(diff+"............");*/
		long day = diff/nd;//计算差多少天
		long hour = diff%nd/nh;//计算差多少小时
		long min = diff%nd%nh/nm;//计算差多少分钟
		long sec = diff%nd%nh%nm/ns;//计算差多少秒//输出结果
		return day+"天"+hour+"小时"+min+"分钟"+sec+"秒";
	}
	
	  //获取当天00:00的日期
 	 public static Date DateTimeToDate(Date datetime) {
 		 String datetimeStr=DateToString(datetime, formatStr_yyyyMMdd);
 		 Date dateOnly=StringToDate(datetimeStr, formatStr_yyyyMMdd);
 		 return dateOnly;
 	 }
	  //获取两个日期的天数差
 	 public static int numOfTwoDays(Date startDate,Date endDate){
 		long start= DateTimeToDate(startDate).getTime();
 		long end= DateTimeToDate(endDate).getTime();
 		long numDays=Math.abs(((end-start)/1000/60/60/24));
 		return (int) numDays;
 		
 	 }
	
	/** 
	 * 统一的时间显示 ： 一分钟前，xx分钟前，一个小时前，xx个小时前，昨天，前天，3天前，日期
	 * @param date
	 * @return
	 */
	public static String getDateStr(Date date) {
		if(date==null){
			return "";
		}
		Date nowDate = new Date();
		long temp=nowDate.getTime()-date.getTime();
		if(temp<0){
			return DateToString(date, formatStr_yyyymmdd);
		}
		
		int dayNums=numOfTwoDays(nowDate, date);//获取今天和date的天数差
		if(dayNums>3){
			return DateToString(date, formatStr_yyyymmdd);
		}
		if(dayNums==3){
			return "3天前";
		}
		if(dayNums==2){
			return "前天";
		}
		if(dayNums==1){
			return "昨天";
		}
		if(temp>=1*60*60*1000){//超过或等于1小时
			int hours=(int) (temp/60/60/1000);
			return hours+"个小时前";
		}
		if(temp>1*60*1000){//超过1分钟
			int minutes=(int) (temp/60/1000);
			return minutes+"分钟前";
		}
		return "1分钟前";
	}
	/**
	 * 获取验证码时间（5分钟之前）
	 * @return
	 */
//	public static Date getCodeTime(){
//		Date now = new Date();
//		Date codeTime = new Date(now.getTime() - Constant.CODE_VALIDATE_TIME);
//		return codeTime;
//	}
	
	/**
	 * 日期加day天
	 * @param day
	 * @return
	 */
	public static Date getAfterDate(int day, Date nowDay) {
		Calendar date = Calendar.getInstance();
		date.setTime(nowDay);
		date.add(Calendar.DATE, day);// 向后推day
		return date.getTime();
	}
	
	/** 
     * 获取日期中的年 
     * @param date 日期 
     * @return 年份 
     */ 
    public static String getYear(Date date){ 
       DateFormat f_year = new SimpleDateFormat("yyyy"); 
       return f_year.format(date).toString(); 
    } 

    /** 
     * 获取日期中的月 
     * @param date 日期 
     * @return 月份 
     */ 
    public static String getMonth(Date date){ 
        DateFormat f_month=new SimpleDateFormat("MM"); 
        return f_month.format(date).toString(); 
    } 

    /** 
     * 获取日期中天 
     * @param date 日期 
     * @return 天 
     */ 
    public static String getDay(Date date){ 
        DateFormat f_day=new SimpleDateFormat("dd"); 
        return f_day.format(date).toString(); 
    } 
    
    /** 
     * 获取日期中天 
     * @param date 日期 
     * @return 天 
     */ 
    public static String getHours(Date date){ 
        DateFormat f_day=new SimpleDateFormat("HH"); 
        return f_day.format(date).toString(); 
    }
    
    /** 
     * 获取日期中天 
     * @param date 日期 
     * @return 天 
     */ 
    public static String getMinutes(Date date){ 
        DateFormat f_day=new SimpleDateFormat("mm"); 
        return f_day.format(date).toString(); 
    }
    
    /** 
     * 获取日期中天 
     * @param date 日期 
     * @return 天 
     */ 
    public static String getSeconds(Date date){ 
        DateFormat f_day=new SimpleDateFormat("ss"); 
        return f_day.format(date).toString(); 
    }
    
    /**
     * 查询日期是否为当前时间
     * @param date
     * @return
     */
    public static boolean getIsNow(Date date){
    	//当前时间
        Date now = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        //获取今天的日期
        String nowDay = sf.format(now);
        //对比的时间
        String day = sf.format(date);
        return day.equals(nowDay);
    }
    
    /**
     * 根据日期获取该日期是周几
     * @param date
     * @return
     */
     public static int getWeek(Date date) {
    	Calendar c = Calendar.getInstance();
 		c.setTime(date);
 		return c.get(Calendar.DAY_OF_WEEK);
	}
     
     /**
      * 根据日期获取num天后的时间
      * @param date
      * @param num
      * @return
      */
     public static Date plusDay(Date date,int num){
    	 Calendar c = Calendar.getInstance();
    	 c.setTime(date);
    	 c.add(Calendar.DATE, num);
    	 return c.getTime();
     }
     
     public static Date getDayOnlyYYYYMMDD(Date date){
    	 Calendar c = Calendar.getInstance();
    	 c.setTime(date);
    	 // 将时分秒,毫秒域清零
    	 c.set(Calendar.HOUR_OF_DAY, 0);
    	 c.set(Calendar.MINUTE, 0);
    	 c.set(Calendar.SECOND, 0);
    	 c.set(Calendar.MILLISECOND, 0);
    	 return c.getTime();
     }
}
