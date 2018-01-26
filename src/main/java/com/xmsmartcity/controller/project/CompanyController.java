package com.xmsmartcity.controller.project;

import com.xmsmartcity.pojo.BaseResponse;
import com.xmsmartcity.pojo.TcCompany;
import com.xmsmartcity.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author: EzerXie
 * @Description:
 * @Date: Created on 15:45 2018/1/25
 * @Modified By:
 */
@RestController
@RequestMapping(value = "/project_company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @RequestMapping(value = "/insert")
    public BaseResponse<TcCompany> insertCompany(String uId,TcCompany company){
        BaseResponse<TcCompany> baseResponse = new BaseResponse<>();
        try{
            if(uId==null||uId.equals("")){
                baseResponse.setInfo("参数错误，创建失败");
                return baseResponse;
            }
            if(company.getName()==null||company.getName().equals("")){
                baseResponse.setInfo("参数错误，创建失败");
                return baseResponse;
            }
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            company.setCreateTime(timestamp);
            company.setUpdateTime(timestamp);
            company.setCreatePersonId(Integer.parseInt(uId));
            TcCompany tcCompany = companyService.insertCompany2(company);
            if(tcCompany==null) {
                baseResponse.setInfo("服务器错误,创建失败");
                return baseResponse;
            }
            baseResponse.setData(tcCompany);
            baseResponse.setCode(1);
            return baseResponse;
        }catch (Exception e){
            baseResponse.setInfo("参数错误，创建失败");
            return baseResponse;
        }
    }

    @RequestMapping(value = "/delect")
    public BaseResponse<TcCompany> delect(int uId,int cId){
        BaseResponse<TcCompany> baseResponse = new BaseResponse<>();
        TcCompany tcCompany = companyService.selectByPrimaryKey(cId);
        if(tcCompany==null){
            baseResponse.setInfo("无此公司");
            return baseResponse;
        }
        if(tcCompany.getCreatePersonId()!=uId){
            baseResponse.setInfo("无权限删除");
            return baseResponse;
        }
        String s = companyService.delectCompany(cId);
        if(s.equals("-1")){
            baseResponse.setInfo("删除失败");
        }
        baseResponse.setCode(1);
        baseResponse.setInfo("删除成功");
        return baseResponse;
    }

    @RequestMapping(value = "/update")
    public BaseResponse<TcCompany> update(int uId,int cId,TcCompany company){
        BaseResponse<TcCompany> baseResponse = new BaseResponse<>();
        try {
            TcCompany tcCompany = companyService.selectByPrimaryKey(cId);
            if(tcCompany==null){
                baseResponse.setInfo("无此公司");
                return baseResponse;
            }
            if(tcCompany.getCreatePersonId()!=uId){
                baseResponse.setInfo("无修改权限");
                return baseResponse;
            }
            if(uId<=0){
                baseResponse.setInfo("参数错误，修改失败");
                return baseResponse;
            }
            if(cId<=0){
                baseResponse.setInfo("参数错误，修改失败");
                return baseResponse;
            }
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            company.setUpdateTime(timestamp);
            String s = companyService.updateCompany(company);
            if("-1".equals(s)){
                baseResponse.setInfo("参数错误，修改失败");
                return baseResponse;
            }
            baseResponse.setData(companyService.selectByPrimaryKey(cId));
            baseResponse.setCode(1);
        }catch (Exception e){
            baseResponse.setInfo("参数错误，修改失败");
        }
        return baseResponse;
    }

}
