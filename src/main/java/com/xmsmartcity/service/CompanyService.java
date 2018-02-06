package com.xmsmartcity.service;

import com.xmsmartcity.pojo.TcCompany;
import com.xmsmartcity.pojo.TpProject;

import java.util.List;

/**
 * @Author: EzerXie
 * @Description:
 * @Date: Created on 10:30 2018/1/25
 * @Modified By:
 */
public interface CompanyService extends BaseService<TcCompany> {

    //新增公司
    public String insertCompany(TcCompany company);

    public TcCompany insertCompany2(TcCompany company);

    //删除公司
    public String delectCompany(int cId);

    //修改公司
    public String updateCompany(TcCompany company);

    //查询/搜索 公司
    public List<TcCompany> selectAllCompany(int uId);

    public TcCompany selectCompanyById(int id);

}
