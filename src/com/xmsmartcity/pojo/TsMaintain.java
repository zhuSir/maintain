package com.xmsmartcity.pojo;

import java.util.Date;

public class TsMaintain {
    private Integer id;

    private Integer faultId;

    private String maintainCode;

    private Integer companyId;

    private Integer projectId;

    private Integer faultUserId;

    private Integer equipId;

    private Date finashDate;

    private Integer maintainUserId;

    private String remarkReason;

    private String maintainType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFaultId() {
        return faultId;
    }

    public void setFaultId(Integer faultId) {
        this.faultId = faultId;
    }

    public String getMaintainCode() {
        return maintainCode;
    }

    public void setMaintainCode(String maintainCode) {
        this.maintainCode = maintainCode == null ? null : maintainCode.trim();
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getFaultUserId() {
        return faultUserId;
    }

    public void setFaultUserId(Integer faultUserId) {
        this.faultUserId = faultUserId;
    }

    public Integer getEquipId() {
        return equipId;
    }

    public void setEquipId(Integer equipId) {
        this.equipId = equipId;
    }

    public Date getFinashDate() {
        return finashDate;
    }

    public void setFinashDate(Date finashDate) {
        this.finashDate = finashDate;
    }

    public Integer getMaintainUserId() {
        return maintainUserId;
    }

    public void setMaintainUserId(Integer maintainUserId) {
        this.maintainUserId = maintainUserId;
    }

    public String getRemarkReason() {
        return remarkReason;
    }

    public void setRemarkReason(String remarkReason) {
        this.remarkReason = remarkReason == null ? null : remarkReason.trim();
    }

    public String getMaintainType() {
        return maintainType;
    }

    public void setMaintainType(String maintainType) {
        this.maintainType = maintainType == null ? null : maintainType.trim();
    }
}