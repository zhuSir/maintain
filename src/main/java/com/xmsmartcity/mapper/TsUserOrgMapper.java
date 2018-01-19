package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsUserOrg;

public interface TsUserOrgMapper {
    int deleteByPrimaryKey(String id);

    int insert(TsUserOrg record);

    int insertSelective(TsUserOrg record);

    TsUserOrg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TsUserOrg record);

    int updateByPrimaryKey(TsUserOrg record);
}