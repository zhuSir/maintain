package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsPermission_role;

/**
 * Created by lingyun on 2018/2/26.
 */
public interface TsPermission_roleMapper {

    //查询拥有某权限的角色
   TsPermission_role selectPermissionByroleId(int id);


    //查询某角色拥有的权限。
    TsPermission_role selectRoleByrolePermission(int id);


}
