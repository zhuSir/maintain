package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TcCompany;

import java.util.List;

public interface TcCompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TcCompany record);

    int insertSelective(TcCompany record);

    TcCompany selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TcCompany record);

    int updateByPrimaryKey(TcCompany record);

    List<TcCompany> selectAllCompany(int uId);

    TcCompany selectCompanyById(Integer id);

    int delectCompany(int id);
}