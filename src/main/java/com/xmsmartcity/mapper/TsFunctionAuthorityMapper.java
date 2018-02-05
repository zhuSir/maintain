package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsFunctionAuthority;

public interface TsFunctionAuthorityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TsFunctionAuthority record);

    int insertSelective(TsFunctionAuthority record);

    TsFunctionAuthority selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TsFunctionAuthority record);

    int updateByPrimaryKey(TsFunctionAuthority record);

    TsFunctionAuthority selectWithConpanyIDKey(Integer id);
}