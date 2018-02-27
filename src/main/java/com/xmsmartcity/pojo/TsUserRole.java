package com.xmsmartcity.pojo;

/**
 * Created by lingyun on 2018/2/9.
 */
/*
*
*    用户和角色的实体类
 */
public class TsUserRole {


    private int id;
    private TsRole role;
    private TsUser user;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public TsRole getRole() {
        return role;
    }
    public void setRole(TsRole role) {
        this.role = role;
    }
    public TsUser getUser() {
        return user;
    }
    public void setUser(TsUser user) {
        this.user = user;
    }


}
