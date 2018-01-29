package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsRoleOrg;

public interface TsRoleOrgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TsRoleOrg record);

    int insertSelective(TsRoleOrg record);

    TsRoleOrg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TsRoleOrg record);

    int updateByPrimaryKey(TsRoleOrg record);
}