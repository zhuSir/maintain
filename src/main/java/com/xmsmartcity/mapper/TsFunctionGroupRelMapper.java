package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsFunctionGroupRel;

public interface TsFunctionGroupRelMapper {
    int deleteByPrimaryKey(String id);

    int insert(TsFunctionGroupRel record);

    int insertSelective(TsFunctionGroupRel record);

    TsFunctionGroupRel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TsFunctionGroupRel record);

    int updateByPrimaryKey(TsFunctionGroupRel record);


}