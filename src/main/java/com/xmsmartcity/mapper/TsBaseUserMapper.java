package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsBaseUser;

public interface TsBaseUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(TsBaseUser record);

    int insertSelective(TsBaseUser record);

    TsBaseUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TsBaseUser record);

    int updateByPrimaryKeyWithBLOBs(TsBaseUser record);

    int updateByPrimaryKey(TsBaseUser record);
}