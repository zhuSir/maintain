package com.xmsmartcity.pojo;

/**
 * @Author: EzerXie
 * @Description:
 * @Date: Created on 11:12 2018/1/25
 * @Modified By:
 */
public class BaseResponse<T> {
    int code = 0;
    String info;
    T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
