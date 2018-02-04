package com.xmsmartcity.service.impl;

import com.xmsmartcity.mapper.BaseDao;
import com.xmsmartcity.mapper.TcCompanyMapper;
import com.xmsmartcity.pojo.TcCompany;
import com.xmsmartcity.pojo.TpProject;
import com.xmsmartcity.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: EzerXie
 * @Description:
 * @Date: Created on 11:41 2018/1/25
 * @Modified By:
 */

@Service("companyService")
public class CompanyServiceImpl extends BaseServiceImpl<TcCompany> implements CompanyService {

    public CompanyServiceImpl(BaseDao<TcCompany> dao) {
        super(dao);
    }

    @Autowired
    private TcCompanyMapper dao;

    @Override
    public String insertCompany(TcCompany company) {
        int insert = dao.insertSelective(company);
        if (insert == -1)
            return insert + "";
        else return company.getId() + "";
    }

    @Override
    public TcCompany insertCompany2(TcCompany company) {
        int insert = dao.insertSelective(company);
        if (insert == -1)
            return null;
        else return company;
    }

    @Override
    public String delectCompany(int cId) {
        return null;
    }

    @Override
    public String updateCompany(TcCompany company) {
        int update = dao.updateByPrimaryKeySelective(company);
        return update + "";
    }

    @Override
    public List<TcCompany> selectAllCompany(int uId) {
        List<TcCompany> tcCompanies = dao.selectAllCompany(uId);
        return tcCompanies;
    }

}
