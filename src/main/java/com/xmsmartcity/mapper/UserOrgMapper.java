package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.UserOrg;

public interface UserOrgMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserOrg record);

    int insertSelective(UserOrg record);

    UserOrg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserOrg record);

    int updateByPrimaryKey(UserOrg record);
}