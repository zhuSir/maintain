package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsRole;
import com.xmsmartcity.pojo.TsUser;
import com.xmsmartcity.pojo.TsUserRole;

/**
 * Created by lingyun on 2018/2/9.
 */
/*
*   用户和角色关联Mapper
 */
public interface TsUser_RoleMapper {

     //查询拥有某角色的用户信息
     TsUserRole selectUserInfoByRoleId(int id);
    //查询某用户对应的角色
    TsUserRole selectRoleByUserId(int id);


}
