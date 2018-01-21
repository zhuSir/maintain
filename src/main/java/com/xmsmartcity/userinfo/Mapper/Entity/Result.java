package com.xmsmartcity.userinfo.Mapper.Entity;

/**
 * Created by lingyun on 2018/1/19.
 */
public class Result<T> {


    /**
     * 返回错误码
     */
    private Integer code;
    /**
     * 返回提示信息
     */
    private String msg;
    /**
     * 具体内容
     */
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
