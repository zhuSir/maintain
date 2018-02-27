package com.xmsmartcity.pojo;

/**
 * Created by lingyun on 2018/2/26.
 */
public class TsPermission_role {

    private Integer id;
  private  TsPermission permission;
    private TsRole role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TsRole getRole() {
        return role;
    }

    public void setRole(TsRole role) {
        this.role = role;
    }

    public TsPermission getPermission() {
        return permission;
    }

    public void setPermission(TsPermission permission) {
        this.permission = permission;
    }
}
