package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.*;

import java.util.List;

/**
 * Created by lingyun on 2018/2/9.
 */
/*
*   用户和角色关联Mapper
 */
public interface TsUser_RoleMapper {

     //查询所有用户的所有角色信息
    public List<TsUser> selectUserRoles() throws Exception;

    // * 删除指定id用户的某角色（根据id）角色
    public void  deleteUserByroleId(TsUserRole userRole);

   //  查询User级联查询出所选的roles并且组装成完整的对象
    public TsUser getUserByIdWithRoles(Integer user_id) throws Exception;

    //  查询role级联查询出所选的Users并且组装成完整的对象
    public  TsRole getRoleByIdWithUsers(Integer role_id) throws Exception;

    //插入user和role关联
    public void insertUserRole(TsUserRole userRole);


}
