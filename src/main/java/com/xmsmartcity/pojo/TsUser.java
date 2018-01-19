package com.xmsmartcity.pojo;

import java.util.Date;

public class TsUser {
    private String id;

    private String email;

    private String mobilephone;

    private String officephone;

    private String signaturefile;

    private String updateName;

    private Date updateDate;

    private String updateBy;

    private String createName;

    private Date createDate;

    private String createBy;

    private String portrait;

    private String imsign;

    private String devFlag;

    private  String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone == null ? null : mobilephone.trim();
    }

    public String getOfficephone() {
        return officephone;
    }

    public void setOfficephone(String officephone) {
        this.officephone = officephone == null ? null : officephone.trim();
    }

    public String getSignaturefile() {
        return signaturefile;
    }

    public void setSignaturefile(String signaturefile) {
        this.signaturefile = signaturefile == null ? null : signaturefile.trim();
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName == null ? null : updateName.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait == null ? null : portrait.trim();
    }

    public String getImsign() {
        return imsign;
    }

    public void setImsign(String imsign) {
        this.imsign = imsign == null ? null : imsign.trim();
    }

    public String getDevFlag() {
        return devFlag;
    }

    public void setDevFlag(String devFlag) {
        this.devFlag = devFlag == null ? null : devFlag.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}