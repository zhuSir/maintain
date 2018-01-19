package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsUser;

public interface TsUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(TsUser record);

    int insertSelective(TsUser record);

    TsUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TsUser record);

    int updateByPrimaryKey(TsUser record);
}