package com.xmsmartcity.service;
import com.xmsmartcity.pojo.TsPermission_role;
import com.xmsmartcity.pojo.TsRole;
import com.xmsmartcity.pojo.TsUser;
import com.xmsmartcity.pojo.TsUserRole;

import java.util.List;
import java.util.Map;

/**
 * Created by lingyun on 2018/2/6.
 */
public interface RoleService extends BaseService<TsRole> {

    List<TsRole> findAllroles();
    List<TsRole> findRolesByRoleName(String rolename);
    TsRole selectByroleCode(String rolecode);
    TsUserRole selectUserInfoByRoleId(int id);
    TsUserRole selectRoleByUserId(int id);

    List<String>  selectPermissionByRoleName(String roleName);
    List<String>  selectRoleByPermissionName(String permissionName);



}
