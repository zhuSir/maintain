package com.xmsmartcity.pojo;

/**
 * Created by lingyun on 2018/2/26.
 */
public class TsPermission_role {

    private Integer id;
     private  int  permissionId;
    private int roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }
}
