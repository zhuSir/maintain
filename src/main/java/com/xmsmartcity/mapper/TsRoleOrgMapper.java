package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsRoleOrg;

public interface TsRoleOrgMapper {
    int deleteByPrimaryKey(String id);

    int insert(TsRoleOrg record);

    int insertSelective(TsRoleOrg record);

    TsRoleOrg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TsRoleOrg record);

    int updateByPrimaryKey(TsRoleOrg record);
}