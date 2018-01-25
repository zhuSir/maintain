package com.xmsmartcity.pojo;

import com.sun.istack.internal.Nullable;

import java.sql.Timestamp;

public class TpProject {

    @Nullable
    private Integer id ;

    private String name;

    private Integer depId;

    private String depName;

    private Integer bidState;

    private Float lat;

    private Float lng;

    private String provice;

    private String city;

    private String area;

    private String addr;

    private Integer owenerUnitId;
    private String owenerUnitName;

    private Integer constructUnitId;
    private String constructUnitName;

    private String mark;

    private Timestamp planStartDate;

    private Timestamp planEndDate;

    private String caption;

    private Integer managerId;

    private String managerName;

    private Integer projectState;

    private Integer auditState;

    private Integer auditPersonId;
    private String auditPersonName;

    private Timestamp auditDate;

    private Integer createPersonId;
    private String createPersonName;

    private Timestamp createTime;

    private Timestamp updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public Integer getBidState() {
        return bidState;
    }

    public void setBidState(Integer bidState) {
        this.bidState = bidState;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice == null ? null : provice.trim();
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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public Integer getOwenerUnitId() {
        return owenerUnitId;
    }

    public void setOwenerUnitId(Integer owenerUnitId) {
        this.owenerUnitId = owenerUnitId;
    }

    public Integer getConstructUnitId() {
        return constructUnitId;
    }

    public void setConstructUnitId(Integer constructUnitId) {
        this.constructUnitId = constructUnitId;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public Timestamp getPlanStartDate() {
        return planStartDate;
    }

    public void setPlanStartDate(Timestamp planStartDate) {
        this.planStartDate = planStartDate;
    }

    public Timestamp getPlanEndDate() {
        return planEndDate;
    }

    public void setPlanEndDate(Timestamp planEndDate) {
        this.planEndDate = planEndDate;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption == null ? null : caption.trim();
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getProjectState() {
        return projectState;
    }

    public void setProjectState(Integer projectState) {
        this.projectState = projectState;
    }

    public Integer getAuditState() {
        return auditState;
    }

    public void setAuditState(Integer auditState) {
        this.auditState = auditState;
    }

    public Integer getAuditPersonId() {
        return auditPersonId;
    }

    public void setAuditPersonId(Integer auditPersonId) {
        this.auditPersonId = auditPersonId;
    }

    public Timestamp getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Timestamp auditDate) {
        this.auditDate = auditDate;
    }

    public Integer getCreatePersonId() {
        return createPersonId;
    }

    public void setCreatePersonId(Integer createPersonId) {
        this.createPersonId = createPersonId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getOwenerUnitName() {
        return owenerUnitName;
    }

    public void setOwenerUnitName(String owenerUnitName) {
        this.owenerUnitName = owenerUnitName;
    }

    public String getConstructUnitName() {
        return constructUnitName;
    }

    public void setConstructUnitName(String constructUnitName) {
        this.constructUnitName = constructUnitName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getAuditPersonName() {
        return auditPersonName;
    }

    public void setAuditPersonName(String auditPersonName) {
        this.auditPersonName = auditPersonName;
    }

    public String getCreatePersonName() {
        return createPersonName;
    }

    public void setCreatePersonName(String createPersonName) {
        this.createPersonName = createPersonName;
    }

    @Override
    public String toString() {
        return "TpProject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", depId=" + depId +
                ", depName='" + depName + '\'' +
                ", bidState=" + bidState +
                ", lat=" + lat +
                ", lng=" + lng +
                ", provice='" + provice + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", addr='" + addr + '\'' +
                ", owenerUnitId=" + owenerUnitId +
                ", owenerUnitName='" + owenerUnitName + '\'' +
                ", constructUnitId=" + constructUnitId +
                ", constructUnitName='" + constructUnitName + '\'' +
                ", mark='" + mark + '\'' +
                ", planStartDate=" + planStartDate +
                ", planEndDate=" + planEndDate +
                ", caption='" + caption + '\'' +
                ", managerId=" + managerId +
                ", managerName='" + managerName + '\'' +
                ", projectState=" + projectState +
                ", auditState=" + auditState +
                ", auditPersonId=" + auditPersonId +
                ", auditPersonName='" + auditPersonName + '\'' +
                ", auditDate=" + auditDate +
                ", createPersonId=" + createPersonId +
                ", createPersonName='" + createPersonName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}