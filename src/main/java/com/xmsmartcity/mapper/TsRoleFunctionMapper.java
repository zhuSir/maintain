package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsRoleFunction;

public interface TsRoleFunctionMapper {
    int deleteByPrimaryKey(String id);

    int insert(TsRoleFunction record);

    int insertSelective(TsRoleFunction record);

    TsRoleFunction selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TsRoleFunction record);

    int updateByPrimaryKey(TsRoleFunction record);
}