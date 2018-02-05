package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsAuthorityList;

public interface TsAuthorityListMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TsAuthorityList record);

    int insertSelective(TsAuthorityList record);

    TsAuthorityList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TsAuthorityList record);

    int updateByPrimaryKey(TsAuthorityList record);
}