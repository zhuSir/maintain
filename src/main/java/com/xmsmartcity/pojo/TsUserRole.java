package com.xmsmartcity.pojo;

import java.util.List;

/**
 * Created by lingyun on 2018/2/9.
 */
/*
*
*    用户和角色的实体类
 */
public class TsUserRole {


    private int id;
    private int  roleId;
    private int  userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
