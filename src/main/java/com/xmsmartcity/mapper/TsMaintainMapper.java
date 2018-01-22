package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsMaintain;

public interface TsMaintainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TsMaintain record);

    int insertSelective(TsMaintain record);

    TsMaintain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TsMaintain record);

    int updateByPrimaryKey(TsMaintain record);
}