package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsFunctionGroup;

public interface TsFunctionGroupMapper {

    int deleteByPrimaryKey(String id);

    int insert(TsFunctionGroup record);

    int insertSelective(TsFunctionGroup record);

    TsFunctionGroup selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TsFunctionGroup record);

    int updateByPrimaryKey(TsFunctionGroup record);


}