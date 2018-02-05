package com.xmsmartcity.controller.userInfo;



import com.alibaba.fastjson.JSONObject;
import com.xmsmartcity.pojo.CommonObjParam;
import com.xmsmartcity.pojo.CommonObjReturn;
import com.xmsmartcity.pojo.TsFunctionGroup;
import com.xmsmartcity.service.UserGroupService;
import com.xmsmartcity.service.UserService;
import com.xmsmartcity.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by welleast on 2018/1/23.
 */
@SpringBootApplication
@RestController
public class GroupControllrer {

    @Autowired
    private   UserGroupService ser;

    @Autowired
    private UserService userService;

    /**
     * 创建公司
     * @return
     */
//    @RequestMapping(value="/user/creatcompany",method = RequestMethod.POST)
    public CommonObjReturn creatCompany(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response){
        HashMap obj = (HashMap) objparam.getData();
        Integer id =   Integer.parseInt((String) obj.get("createUserId"));
        CommonObjReturn commonObjReturn=new CommonObjReturn();
        JSONObject resault =  ser.creatGroup((String)obj.get("groupName"),(String)obj.get("createName"),id);
        commonObjReturn.setData(resault);
        commonObjReturn.setResult("true");
        commonObjReturn.setResultTime(DateUtils.DateToString(new Date(),DateUtils.formatStr_yyyyMMddHHmmss));
        return commonObjReturn;
    }

    /**
     * 创建组
     * @return
     */
    @RequestMapping(value="/user/creatGroup",method = RequestMethod.POST)
    private String creatGroup(String groupname,String companyID,String reatUserName,int reatUserID){

         String resault =  ser.insertGroup(groupname,companyID,reatUserName,reatUserID);

        return resault;
    }


    //获取子组的列表
    @RequestMapping(value="/user/getGroupList",method = RequestMethod.POST)
    private List getGroupList(String sonGroupID){

        List<TsFunctionGroup> result  = ser.getGroupList(sonGroupID);
        return result;
    }

    //获取公司的详情
//    @RequestMapping(value="/user/getCompanyInfo",method = RequestMethod.POST)
//    private CommonObjReturn getcompanyInfo(int companyID){
//        TsFunctionGroup resultg  = ser.getcompanyInfo(companyID);
//
//        CommonObjReturn commonObjReturn=new CommonObjReturn();
//        commonObjReturn.setData(resultg);
//        commonObjReturn.setResult("true");
//        commonObjReturn.setResultTime(DateUtils.DateToString(new Date(),DateUtils.formatStr_yyyyMMddHHmmss));
//        return commonObjReturn;
//
//    }
    public CommonObjReturn getCompanyInfo(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response) {
        HashMap obj = (HashMap) objparam.getData();
        Integer id =   Integer.parseInt((String) obj.get("companyID"));
        TsFunctionGroup resultg  = ser.getcompanyInfo(id);


        CommonObjReturn commonObjReturn=new CommonObjReturn();
        commonObjReturn.setData(resultg);
        commonObjReturn.setResult("true");
        commonObjReturn.setResultTime(DateUtils.DateToString(new Date(),DateUtils.formatStr_yyyyMMddHHmmss));
        return commonObjReturn;
    }


        @GetMapping(value = "/user/companyInviteMember")
    private String companyInviteMenber(String phone,String companyID)
    {
        String  result = ser.companyInviteMenber(phone,companyID);

        return result;
    }

    /**
     * 获取公司成员
     * @param companyID
     * @return
     */
    @RequestMapping(value="/user/listCompanyMember",method = RequestMethod.POST)
    private JSONObject listCompanyMember(int companyID){
        JSONObject result = userService.selectUserList(companyID);
        return result;
    }

    //邀请组成员
    @RequestMapping(value = "/user/invitePeopleGroup",method = RequestMethod.POST)
    public Object invitePeopleGroup(String phone,String companyID,String groupID){

        Object  result = userService.invitePeopleGroup(phone,companyID,groupID);
        return result;
    }

}
