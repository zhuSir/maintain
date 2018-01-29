package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsUser;

public interface TsUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TsUser record);

    int insertSelective(TsUser record);

    TsUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TsUser record);

    int updateByPrimaryKey(TsUser record);
}