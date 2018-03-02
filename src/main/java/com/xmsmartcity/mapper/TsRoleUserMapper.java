package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsRoleUser;

public interface TsRoleUserMapper {

    int deleteByPrimaryKey(String id);

    int insert(TsRoleUser record);

    int insertSelective(TsRoleUser record);

    TsRoleUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TsRoleUser record);

    int updateByPrimaryKey(TsRoleUser record);
}