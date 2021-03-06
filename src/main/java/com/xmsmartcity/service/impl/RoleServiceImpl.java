package com.xmsmartcity.service.impl;

import com.xmsmartcity.mapper.BaseDao;
import com.xmsmartcity.mapper.TsRoleMapper;
import com.xmsmartcity.mapper.TsUserMapper;
import com.xmsmartcity.mapper.TsUser_RoleMapper;
import com.xmsmartcity.pojo.TpProject;
import com.xmsmartcity.pojo.TsRole;
import com.xmsmartcity.pojo.TsUser;
import com.xmsmartcity.pojo.TsUserRole;
import com.xmsmartcity.service.RoleService;
import com.xmsmartcity.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lingyun on 2018/2/6.
 */

@Service("RoleService")
public class RoleServiceImpl extends BaseServiceImpl<TsRole> implements RoleService {

    public RoleServiceImpl(BaseDao<TsRole> dao) {
        super(dao);
    }
    @Autowired
    TsRoleMapper rolemapper;

    @Autowired
    TsUser_RoleMapper user_roleMapper;


    /*
    *  查找全部的角色列表
     */
    @Override
    public List<TsRole> findAllroles() {

        return rolemapper.findAllroles();

    }

    @Override
    public List<TsRole> findRolesByRoleName(String rolename) {

        return  rolemapper.findRolesByRoleName(rolename);
    }

    @Override
    public Integer insert(TsRole record) {

        return rolemapper.insert(record);
    }

    @Override
    public Integer updateByPrimaryKey(TsRole record) {
        return rolemapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteByPrimaryKey(Integer id) {

        return rolemapper.deleteByPrimaryKey(id);

    }

    @Override
    public TsRole selectByroleCode(String rolecode) {
        return  rolemapper.selectByroleCode(rolecode);

    }

    @Override
    public TsUserRole selectRoleByUserId(int id) {

        return  user_roleMapper.selectRoleByUserId(id);

    }

    @Override
    public TsUserRole selectUserInfoByRoleId(int id) {


        return  user_roleMapper.selectUserInfoByRoleId(id);


    }
}
