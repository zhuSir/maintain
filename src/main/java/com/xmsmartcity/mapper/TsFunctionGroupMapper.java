package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsFunctionGroup;

public interface TsFunctionGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TsFunctionGroup record);

    int insertSelective(TsFunctionGroup record);

    TsFunctionGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TsFunctionGroup record);

    int updateByPrimaryKey(TsFunctionGroup record);
}