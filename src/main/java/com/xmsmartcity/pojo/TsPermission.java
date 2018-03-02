package com.xmsmartcity.pojo;

import java.util.List;

/**
 * Created by lingyun on 2018/2/26.
 */
public class TsPermission {

    private Integer id;
    private  String permissionName;
    private List<TsRole> roles;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public List<TsRole> getRoles() {
        return roles;
    }

    public void setRoles(List<TsRole> roles) {
        this.roles = roles;
    }
}
