package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsFunctionGroupUser;

public interface TsFunctionGroupUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(TsFunctionGroupUser record);

    int insertSelective(TsFunctionGroupUser record);

    TsFunctionGroupUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TsFunctionGroupUser record);

    int updateByPrimaryKey(TsFunctionGroupUser record);
}