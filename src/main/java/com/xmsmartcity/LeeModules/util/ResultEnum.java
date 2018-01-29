package com.xmsmartcity.leeModules.util;

/**
 * Created by lingyun on 2018/1/28.
 */
public enum  ResultEnum {

    SUCCESS(200,"成功"),//成功
    FAIL(400,"失败"),//失败
    UNAUTHORIZED(401,"未认证（签名错误）"),//未认证（签名错误）
    NOT_FOUND(404,"接口不存在"),//接口不存在
    INTERNAL_SERVER_ERROR(500,"服务器内部错误");//服务器内部错误

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }




}
