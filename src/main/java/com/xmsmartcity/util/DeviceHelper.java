package com.xmsmartcity.util;

/*
 * 
 * 设备helper类，目前暂时先把设备类型的判断作为常量处理
 * 后期可以考虑吧常量写入数据库
 * */
public class DeviceHelper {
	
	private static String device_web = "A01";
	
	private static String device_mobile = "A02";
	
	private static String device_wx = "A03";
	
	public static boolean isMobile (String deviceCode){
		if ((deviceCode.equals(device_mobile)) ||
				(deviceCode.equals(device_wx))){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isWeb (String deviceCode){
		if (deviceCode.equals(device_web)){
			return true;
		}else{
			return false;
		}
	}

}
