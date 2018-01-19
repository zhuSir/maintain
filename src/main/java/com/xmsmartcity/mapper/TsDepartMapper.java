package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsDepart;

public interface TsDepartMapper {
    int deleteByPrimaryKey(String id);

    int insert(TsDepart record);

    int insertSelective(TsDepart record);

    TsDepart selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TsDepart record);

    int updateByPrimaryKeyWithBLOBs(TsDepart record);

    int updateByPrimaryKey(TsDepart record);
}