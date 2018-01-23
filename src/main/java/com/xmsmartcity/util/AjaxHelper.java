package com.xmsmartcity.util;

import com.xmsmartcity.pojo.CommonObjReturn;
import com.xmsmartcity.pojo.ErrorRecord;

import java.util.Date;

public class AjaxHelper {
	
	/*
	 * 
	 * 封装返回的结构体
	 * 
	 */
	private static CommonObjReturn newAjaxReturn(String result, String reason, Object data,
												 ErrorRecord errobj) {
		CommonObjReturn rt = new CommonObjReturn();
		rt.setResult(result);
		rt.setResultTime(CalendarHelper.formatDateWithMillisecond(new Date()));
		rt.setReason(reason);
		rt.setData(data);
		rt.setError(errobj);
		return rt;
	}

	// 成功返回
	public static CommonObjReturn newSuccess(String reason, Object data) {
		return newAjaxReturn("true", reason, data, null);
	}

	// 失败返回，带Error对象，用于在代码主动catch异常时抛出
	public static CommonObjReturn newFaildForBusinessError(ErrorRecord errobj, Object data) {
		return newAjaxReturn("false", errobj.getComment(), data, errobj);
	}

	// 失败返回，此错误方式仅适用于非业务代码catch的时候抛出，属于系统级别的错误，
	// 禁止在代码主动catch到异常的时候使用这种方式抛出，代码catch异常抛出必须使用newFaildForBusinessError
	public static CommonObjReturn newFaildForSystemError() {
		return newAjaxReturn("false", "系统出现故障，请联系管理员进行处理", null, null);
	}

}
