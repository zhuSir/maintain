package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsRole;

public interface TsRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(TsRole record);

    int insertSelective(TsRole record);

    TsRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TsRole record);

    int updateByPrimaryKey(TsRole record);
}