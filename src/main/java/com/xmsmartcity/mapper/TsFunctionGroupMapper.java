package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsFunctionGroup;

import java.util.List;

public interface TsFunctionGroupMapper {

    int deleteByPrimaryKey(String id);

    int insert(TsFunctionGroup record);

    int insertSelective(TsFunctionGroup record);

    TsFunctionGroup selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TsFunctionGroup record);

    int updateByPrimaryKey(TsFunctionGroup record);



    //获取组列表
    List<TsFunctionGroup> getGroupList(String conpantID);
}