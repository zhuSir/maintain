package com.xmsmartcity.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarHelper {

	public static String dateformat = "yyyy-MM-dd HH:mm:ss";
	public static String dateformatWithMillisecond = "yyyy-MM-dd HH:mm:ss.SSS";

	public static String formatDate(Date date) {
		return new SimpleDateFormat(dateformat).format(date);
	}
	
	public static String formatDateWithMillisecond(Date date) {
		return new SimpleDateFormat(dateformatWithMillisecond).format(date);
	}

	public static Date parseDate(String datestr) throws Exception {
		return new SimpleDateFormat(dateformat).parse(datestr);
	}
	
	public static Date parseDateWithMillisecond(String datestr) throws Exception {
		return new SimpleDateFormat(dateformatWithMillisecond).parse(datestr);
	}
	

}
