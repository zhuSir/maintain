package com.xmsmartcity.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie帮助类
 */
public class CookieHelper {

	private static int cookieage = 30 * 24 * 60 * 60;

	public static void newCookie(String name, String value, boolean isHttpOnly, HttpServletResponse response) {
		Cookie cookie = new Cookie(name, value);
		cookie.setPath("/");
		cookie.setMaxAge(cookieage);
		if (isHttpOnly) cookie.setHttpOnly(true);
		response.addCookie(cookie);
		
	}

	public static String getCookie(String name, HttpServletRequest request)  {
		Cookie[] cookies = request.getCookies();  
		if (cookies != null && cookies.length > 0) {  
		    for (Cookie cookie : cookies) {  
		        String tempname = cookie.getName();  
		        // 找到需要删除的Cookie  
		        if (tempname.equals(name)) {  
		            return cookie.getValue();
		        }  
		    }  
		}  
		return null;
	}

	public static void removeCookie(String name, HttpServletRequest request, HttpServletResponse response)  {
		Cookie[] cookies = request.getCookies();  
		if (cookies != null && cookies.length > 0) {  
		    for (Cookie cookie : cookies) {  
		        String tempname = cookie.getName();  
		        // 找到需要删除的Cookie  
		        if (tempname.equals(name)) {  
		            // 设置生存期为0  
		            cookie.setMaxAge(0);  
		            cookie.setPath("/");
		            // 设回Response中生效  
		            response.addCookie(cookie);  
		        }  
		    }  
		}  

	}
	
	public static String  escape (String src)  
	 {  
	  int i;  
	  char j;  
	  StringBuffer tmp = new StringBuffer();  
	  tmp.ensureCapacity(src.length()*6);  
	  
	  for (i=0;i<src.length() ;i++ )  
	  {  
	  
	   j = src.charAt(i);  
	  
	   if (Character.isDigit(j) || Character.isLowerCase(j) || Character.isUpperCase(j))  
	    tmp.append(j);  
	   else  
	    if (j<256)  
	    {  
	    tmp.append( "%" );  
	    if (j<16)  
	     tmp.append( "0" );  
	    tmp.append( Integer.toString(j,16) );  
	    }  
	    else  
	    {  
	    tmp.append( "%u" );  
	    tmp.append( Integer.toString(j,16) );  
	    }  
	  }  
	  return tmp.toString();  
	 }  
	  
	 public static String  unescape (String src)  
	 {  
	  StringBuffer tmp = new StringBuffer();  
	  tmp.ensureCapacity(src.length());  
	  int  lastPos=0,pos=0;  
	  char ch;  
	  while (lastPos<src.length())  
	  {  
	   pos = src.indexOf("%",lastPos);  
	   if (pos == lastPos)  
	    {  
	    if (src.charAt(pos+1)=='u')  
	     {  
	     ch = (char)Integer.parseInt(src.substring(pos+2,pos+6),16);  
	     tmp.append(ch);  
	     lastPos = pos+6;  
	     }  
	    else  
	     {  
	     ch = (char)Integer.parseInt(src.substring(pos+1,pos+3),16);  
	     tmp.append(ch);  
	     lastPos = pos+3;  
	     }  
	    }  
	   else  
	    {  
	    if (pos == -1)  
	     {  
	     tmp.append(src.substring(lastPos));  
	     lastPos=src.length();  
	     }  
	    else  
	     {  
	     tmp.append(src.substring(lastPos,pos));  
	     lastPos=pos;  
	     }  
	    }  
	  }  
	  return tmp.toString();  
	 }  

}
