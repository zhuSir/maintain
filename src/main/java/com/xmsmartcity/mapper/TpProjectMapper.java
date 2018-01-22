package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TpProject;

public interface TpProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TpProject record);

    int insertSelective(TpProject record);

    TpProject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TpProject record);

    int updateByPrimaryKey(TpProject record);
}