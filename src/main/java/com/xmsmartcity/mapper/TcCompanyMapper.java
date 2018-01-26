package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TcCompany;

public interface TcCompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TcCompany record);

    int insertSelective(TcCompany record);

    TcCompany selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TcCompany record);

    int updateByPrimaryKey(TcCompany record);
}