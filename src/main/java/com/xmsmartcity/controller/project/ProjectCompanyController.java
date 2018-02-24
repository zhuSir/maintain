package com.xmsmartcity.controller.project;

import com.alibaba.fastjson.JSON;
import com.xmsmartcity.pojo.*;
import com.xmsmartcity.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @Author: EzerXie
 * @Description:
 * @Date: Created on 15:45 2018/1/25
 * @Modified By:
 */
@Controller
public class ProjectCompanyController {

    @Autowired
    CompanyService companyService;

    @ResponseBody
    public CommonObjReturn listCompany(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response) {
        ProjectCompanyBean projectCompanyBean = JSON.parseObject(JSON.toJSONString(objparam.getData()), ProjectCompanyBean.class);
        CommonObjReturn commonObjReturn=new CommonObjReturn();
        try {
            if (projectCompanyBean.getuId() == null || projectCompanyBean.getuId().equals("")) {
                commonObjReturn.setReason("参数错误，查询失败");
                commonObjReturn.setResult("false");
                return commonObjReturn;
            }
            List<TcCompany> tcCompanies = companyService.selectAllCompany(projectCompanyBean.getuId());
            commonObjReturn.setResult("true");
            commonObjReturn.setData(tcCompanies);
        } catch (Exception e) {
            commonObjReturn.setReason("参数错误，查询失败");
            commonObjReturn.setResult("false");
        }
        return commonObjReturn;
    }

    @ResponseBody
    public CommonObjReturn saveCompany(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response) {
        ProjectCompanyBean projectCompanyBean = JSON.parseObject(JSON.toJSONString(objparam.getData()), ProjectCompanyBean.class);
        CommonObjReturn commonObjReturn=new CommonObjReturn();
        try {
            if (projectCompanyBean.getuId() == null || projectCompanyBean.getuId().equals("")) {
                commonObjReturn.setReason("参数错误，创建失败");
                commonObjReturn.setResult("false");
                return commonObjReturn;
            }
            if (projectCompanyBean.getName() == null || projectCompanyBean.getName().equals("")) {
                commonObjReturn.setReason("参数错误，创建失败");
                commonObjReturn.setResult("false");
                return commonObjReturn;
            }
            TcCompany company = JSON.parseObject(JSON.toJSONString(objparam.getData()), TcCompany.class);
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            company.setCreateTime(timestamp);
            company.setUpdateTime(timestamp);
            company.setCreatePersonId(projectCompanyBean.getuId());
            TcCompany tcCompany = companyService.insertCompany2(company);
            if (tcCompany == null) {
                commonObjReturn.setReason("服务器错误,创建失败");
                commonObjReturn.setResult("false");
                return commonObjReturn;
            }
            commonObjReturn.setData(tcCompany);
            commonObjReturn.setResult("true");
            return commonObjReturn;
        } catch (Exception e) {
            commonObjReturn.setReason("参数错误，创建失败");
            commonObjReturn.setResult("false");
            return commonObjReturn;
        }
    }

    @ResponseBody
    public CommonObjReturn delectCompany(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response) {
        ProjectCompanyBean projectCompanyBean = JSON.parseObject(JSON.toJSONString(objparam.getData()), ProjectCompanyBean.class);
        CommonObjReturn commonObjReturn=new CommonObjReturn();
        TcCompany tcCompany = companyService.selectCompanyById(projectCompanyBean.getId());
        if (tcCompany == null) {
            commonObjReturn.setReason("无此公司");
            commonObjReturn.setResult("false");
            return commonObjReturn;
        }
        if (tcCompany.getCreatePersonId() != projectCompanyBean.getuId()) {
            commonObjReturn.setReason("无权限删除");
            commonObjReturn.setResult("false");
            return commonObjReturn;
        }
        String s = companyService.delectCompany(projectCompanyBean.getId());
        if (s==null||"-1".equals(s)) {
            commonObjReturn.setResult("false");
            commonObjReturn.setReason("删除失败");
        }
        commonObjReturn.setResult("true");
        commonObjReturn.setReason("删除成功");
        return commonObjReturn;
    }

    @ResponseBody
    public CommonObjReturn updateCompany(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response) {
        ProjectCompanyBean projectCompanyBean = JSON.parseObject(JSON.toJSONString(objparam.getData()), ProjectCompanyBean.class);
        CommonObjReturn commonObjReturn=new CommonObjReturn();
        try {
            TcCompany tcCompany = companyService.selectByPrimaryKey(projectCompanyBean.getId());
            if (tcCompany == null) {
                commonObjReturn.setReason("无此公司");
                commonObjReturn.setResult("false");
                return commonObjReturn;
            }
            if (tcCompany.getCreatePersonId() != projectCompanyBean.getuId()) {
                commonObjReturn.setReason("无修改权限");
                commonObjReturn.setResult("false");
                return commonObjReturn;
            }
            if (projectCompanyBean.getuId()==null||projectCompanyBean.getuId().equals("")) {
                commonObjReturn.setReason("参数错误，修改失败");
                commonObjReturn.setResult("false");
                return commonObjReturn;
            }
            if (projectCompanyBean.getId() ==null||projectCompanyBean.getId().equals("")) {
                commonObjReturn.setReason("参数错误，修改失败");
                commonObjReturn.setResult("false");
                return commonObjReturn;
            }
            TcCompany company = JSON.parseObject(JSON.toJSONString(objparam.getData()), TcCompany.class);
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            company.setUpdateTime(timestamp);
            String s = companyService.updateCompany(company);
            if ("-1".equals(s)) {
                commonObjReturn.setReason("参数错误，修改失败");
                commonObjReturn.setResult("false");
                return commonObjReturn;
            }
            commonObjReturn.setData(companyService.selectByPrimaryKey(company.getId()));
            commonObjReturn.setResult("true");
        } catch (Exception e) {
            commonObjReturn.setReason("参数错误，修改失败");
            commonObjReturn.setResult("false");
        }
        return commonObjReturn;
    }

}
