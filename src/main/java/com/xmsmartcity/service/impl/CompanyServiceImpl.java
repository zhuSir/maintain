package com.xmsmartcity.service.impl;

import com.xmsmartcity.mapper.BaseDao;
import com.xmsmartcity.mapper.TcCompanyMapper;
import com.xmsmartcity.pojo.TcCompany;
import com.xmsmartcity.pojo.TpProject;
import com.xmsmartcity.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: EzerXie
 * @Description:
 * @Date: Created on 11:41 2018/1/25
 * @Modified By:
 */
public class CompanyServiceImpl extends BaseServiceImpl<TcCompany> implements CompanyService {

    public CompanyServiceImpl(BaseDao<TcCompany> dao) {
        super(dao);
    }

    @Autowired
    private TcCompanyMapper dao;

    @Override
    public String insertCompany(TcCompany company) {
        int insert = dao.insert(company);
        return insert+"";
    }

    @Override
    public String delectCompany(int pId) {
        return null;
    }

    @Override
    public String updateCompany(TcCompany company) {
        return null;
    }

    @Override
    public List<TpProject> selectAllCompany(int uId) {
        return null;
    }
}
