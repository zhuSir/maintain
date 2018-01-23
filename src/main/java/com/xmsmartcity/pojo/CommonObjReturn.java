package com.xmsmartcity.pojo;

import java.io.Serializable;

/**
 * 通用json反馈报文接口对象
 * Created by BinYiChen on 2018/1/23.
 */

public class CommonObjReturn implements Serializable {

    //返回结果
    private String result;

    //返回的时间  yyyy-mm-dd hh:mm:ss
    private String resultTime;

    //原因字符串，这个一般是出错的时候用来显示给前端客户看的
    private String reason;

    //返回的数据
    private Object data;

    //错误详细信息
    private ErrorRecord error;

    public String getResultTime() {
        return resultTime;
    }

    public void setResultTime(String resultTime) {
        this.resultTime = resultTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ErrorRecord getError() {
        return error;
    }

    public void setError(ErrorRecord error) {
        this.error = error;
    }
}
