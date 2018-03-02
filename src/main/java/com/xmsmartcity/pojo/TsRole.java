package com.xmsmartcity.pojo;

import java.util.Date;
import java.util.List;

public class TsRole {


    private int id;

    private String rolecode;

    private String rolename;

    private String updateName;

    private Date updateDate;

    private String updateBy;

    private String createName;

    private Date createDate;

    private String createBy;

    //角色对应的人员
    private List<TsUser> users;

    //角色对应的权限
    private List<TsPermission> permissions;

    public int getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getRolecode() {
        return rolecode;
    }

    public void setRolecode(String rolecode) {
        this.rolecode = rolecode == null ? null : rolecode.trim();
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
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

    public List<TsUser> getUsers() {
        return users;
    }

    public void setUsers(List<TsUser> users) {
        this.users = users;
    }

    public List<TsPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<TsPermission> permissions) {
        this.permissions = permissions;
    }
}