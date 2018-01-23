package com.xmsmartcity.pojo;

import java.io.Serializable;

/**
 * 通用json请求报文 - security层接口对象
 * 
 * @author wuhy
 * 
 * 
 */

public class CommonSecurityObjParam implements Serializable{
	
	//tocken鉴别
  	private String accessTocken;

  	//短信验证码
  	private String smsCode;
  	
  	//email验证码
  	private String emailCode;
    
    //终端id
    private String deviceId;
    
    //usb密钥
    private String usbKey;
    
    //图片验证码
    private String imageCode;
    
    //随机key，用于回传给前端的
    private String codeKey;
    

	public String getUsbKey() {
		return usbKey;
	}

	public void setUsbKey(String usbKey) {
		this.usbKey = usbKey;
	}

	public String getAccessTocken() {
		return accessTocken;
	}

	public void setAccessTocken(String accessTocken) {
		this.accessTocken = accessTocken;
	}

	public String getSmsCode() {
		return smsCode;
	}

	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}

	public String getEmailCode() {
		return emailCode;
	}

	public void setEmailCode(String emailCode) {
		this.emailCode = emailCode;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getImageCode() {
		return imageCode;
	}

	public void setImageCode(String imageCode) {
		this.imageCode = imageCode;
	}

	public String getCodeKey() {
		return codeKey;
	}

	public void setCodeKey(String codeKey) {
		this.codeKey = codeKey;
	}

}
