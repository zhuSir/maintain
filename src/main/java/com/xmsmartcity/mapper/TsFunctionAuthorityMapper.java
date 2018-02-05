package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsFunctionAuthority;

import java.util.List;

// extends BaseDao<TsUser>
public interface TsFunctionAuthorityMapper extends BaseDao<TsFunctionAuthority> {
    int deleteByPrimaryKey(Integer id);

    int insert(TsFunctionAuthority record);

    int insertSelective(TsFunctionAuthority record);

    TsFunctionAuthority selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TsFunctionAuthority record);

    int updateByPrimaryKey(TsFunctionAuthority record);

    TsFunctionAuthority selectWithConpanyIDKey(Integer id);


    List selectWithGroupListIDKey(Integer id);
}