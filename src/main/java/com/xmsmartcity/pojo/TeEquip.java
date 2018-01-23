package com.xmsmartcity.pojo;

import java.util.Date;

public class TeEquip {
    private Integer id;

    private String equipName;

    private String equipCode;

    private String equipModel;

    private String equipFirm;

    private Integer equipTypeId;

    private String equipDetail;

    private String lng;

    private String lat;

    private String province;

    private String city;

    private String area;

    private String address;

    private Date putUseTime;

    private Date guaranteePeriod;

    private Integer isDel;

    private Date createtime;

    private Integer creatUserId;

    private Date updatetime;

    private Integer updateUserId;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName == null ? null : equipName.trim();
    }

    public String getEquipCode() {
        return equipCode;
    }

    public void setEquipCode(String equipCode) {
        this.equipCode = equipCode == null ? null : equipCode.trim();
    }

    public String getEquipModel() {
        return equipModel;
    }

    public void setEquipModel(String equipModel) {
        this.equipModel = equipModel == null ? null : equipModel.trim();
    }

    public String getEquipFirm() {
        return equipFirm;
    }

    public void setEquipFirm(String equipFirm) {
        this.equipFirm = equipFirm == null ? null : equipFirm.trim();
    }

    public Integer getEquipTypeId() {
        return equipTypeId;
    }

    public void setEquipTypeId(Integer equipTypeId) {
        this.equipTypeId = equipTypeId;
    }

    public String getEquipDetail() {
        return equipDetail;
    }

    public void setEquipDetail(String equipDetail) {
        this.equipDetail = equipDetail == null ? null : equipDetail.trim();
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng == null ? null : lng.trim();
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getPutUseTime() {
        return putUseTime;
    }

    public void setPutUseTime(Date putUseTime) {
        this.putUseTime = putUseTime;
    }

    public Date getGuaranteePeriod() {
        return guaranteePeriod;
    }

    public void setGuaranteePeriod(Date guaranteePeriod) {
        this.guaranteePeriod = guaranteePeriod;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getCreatUserId() {
        return creatUserId;
    }

    public void setCreatUserId(Integer creatUserId) {
        this.creatUserId = creatUserId;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}