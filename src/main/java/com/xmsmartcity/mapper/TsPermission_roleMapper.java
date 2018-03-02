package com.xmsmartcity.mapper;

import com.sun.org.apache.bcel.internal.generic.PUSH;
import com.xmsmartcity.pojo.TsPermission;
import com.xmsmartcity.pojo.TsPermission_role;
import com.xmsmartcity.pojo.TsRole;
import com.xmsmartcity.pojo.TsUser;

import java.util.List;

/**
 * Created by lingyun on 2018/2/26.
 */

public interface TsPermission_roleMapper {

    //查询所有权限
     public   List<TsPermission> selectAllPermissions() ;

    //根据权限名返回权限ID
    public int selectPermissionById(String  permission);

    //根据删除权限
    public  void  deletePermissionbyId(String  permission);

    //查询所有角色和他们的权限信息
    public List<TsRole> selectRolePermissions() throws Exception;

    //查询role级联查询出所选的permission并且组装成完整的对象
    public TsRole getPermissionByIdWithRole(int roleId) throws Exception;

    //查询permission级联查询出所选的role并且组装成完整的对象
    public TsPermission getRoleByIdWithPermission(String permission_name) throws Exception;

    //删除指定角色的某种权限
    public  void  deleteRolePermissionById(TsPermission_role permission_role) throws Exception;

    //插入角色权限关联
    public void  insertRolePermission(TsPermission_role permission_role);


    //根据用户ID关联角色查找对应的权限信息
    public  List<TsPermission> getRoleByUserIdWithPerission(int user_id);

    //查询拥有某权限的用户
    public List<TsUser> getUserPermissionIdWithUser(String permission_name);

}
