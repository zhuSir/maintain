package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsUserOrg;

public interface TsUserOrgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TsUserOrg record);

    int insertSelective(TsUserOrg record);

    TsUserOrg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TsUserOrg record);

    int updateByPrimaryKey(TsUserOrg record);
}