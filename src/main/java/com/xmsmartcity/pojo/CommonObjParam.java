package com.xmsmartcity.pojo;

import java.io.Serializable;

/**
 * 通用json请求报文接口对象
 * Created by BinYiChen on 2018/1/23.
 */
public class CommonObjParam implements Serializable{

	// 调用的方法名
	private String funcName;

	// 调用的服务名
	private String controllerName;

	// 请求序列号，允许空
	private String serialNumber;

	// 请求时间
	private String reqTime;

	// 用户账户
	private String userAccount;

	// 用户账户 id ,前台不用传输，在通过验证后会填入
	private String userId;

	// 用户名称 ,前台不用传输，在通过验证后会填入
	private String userName;

	// 用户邮箱 ,前台不用传输，在通过验证后会填入
	private String userEmail;

	// 用户手机号,前台不用传输，在通过验证后会填入
	private String userMobileNumber;

	// 请求系统编码 00-WEB，01-APP，02-WX
	private String reqSysCode;

	// security层，具体请见CommonSecurityObj
	private CommonSecurityObjParam security;

	// 提交的数据，各api自行定义
	private Object data;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserMobileNumber() {
		return userMobileNumber;
	}

	public void setUserMobileNumber(String userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public CommonSecurityObjParam getSecurity() {
		return security;
	}

	public void setSecurity(CommonSecurityObjParam security) {
		this.security = security;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public String getReqSysCode() {
		return reqSysCode;
	}

	public void setReqSysCode(String reqSysCode) {
		this.reqSysCode = reqSysCode;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getReqTime() {
		return reqTime;
	}

	public void setReqTime(String reqTime) {
		this.reqTime = reqTime;
	}

	public String getFuncName() {
		return funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	public String getControllerName() {
		return controllerName;
	}

	public void setControllerName(String controllerName) {
		this.controllerName = controllerName;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
