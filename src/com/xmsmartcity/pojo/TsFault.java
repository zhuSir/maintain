package com.xmsmartcity.pojo;

public class TsFault {
    private Integer id;

    private String faultCode;

    private Integer companyId;

    private Integer projectId;

    private Integer maintainId;

    private String remarkReason;

    private String faultType;

    private Integer faultUserId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFaultCode() {
        return faultCode;
    }

    public void setFaultCode(String faultCode) {
        this.faultCode = faultCode == null ? null : faultCode.trim();
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

    public Integer getMaintainId() {
        return maintainId;
    }

    public void setMaintainId(Integer maintainId) {
        this.maintainId = maintainId;
    }

    public String getRemarkReason() {
        return remarkReason;
    }

    public void setRemarkReason(String remarkReason) {
        this.remarkReason = remarkReason == null ? null : remarkReason.trim();
    }

    public String getFaultType() {
        return faultType;
    }

    public void setFaultType(String faultType) {
        this.faultType = faultType == null ? null : faultType.trim();
    }

    public Integer getFaultUserId() {
        return faultUserId;
    }

    public void setFaultUserId(Integer faultUserId) {
        this.faultUserId = faultUserId;
    }
}