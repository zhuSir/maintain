package com.xmsmartcity.pojo;

/**
 * @Author: EzerXie
 * @Description:
 * @Date: Created on 9:54 2018/2/23
 * @Modified By:
 */
public class ProjectRequestBean extends TpProject {
    Integer uId;
    String startData;
    String endDate;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getStartData() {
        return startData;
    }

    public void setStartData(String startData) {
        this.startData = startData;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
