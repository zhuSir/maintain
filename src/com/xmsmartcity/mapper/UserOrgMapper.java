package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.UserOrg;

public interface UserOrgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserOrg record);

    int insertSelective(UserOrg record);

    UserOrg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserOrg record);

    int updateByPrimaryKey(UserOrg record);
}