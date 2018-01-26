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

    //删除公司
    public String delectCompany(int pId);

    //修改公司
    public String updateCompany(TcCompany company);

    //查询/搜索 公司
    public List<TpProject> selectAllCompany(int uId);

}
