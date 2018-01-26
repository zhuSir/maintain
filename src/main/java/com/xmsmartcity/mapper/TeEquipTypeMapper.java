package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TeEquipType;

import java.util.List;

public interface TeEquipTypeMapper extends BaseDao<TeEquipType>{

    List<TeEquipType> selectEquipTypeList();

}