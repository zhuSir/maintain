package com.xmsmartcity.controller.userInfo;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xmsmartcity.pojo.CommonObjParam;
import com.xmsmartcity.pojo.CommonObjReturn;
import com.xmsmartcity.pojo.TsFunctionGroup;
import com.xmsmartcity.pojo.TsUser;
import com.xmsmartcity.service.UserGroupService;
import com.xmsmartcity.service.UserService;
import com.xmsmartcity.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    private UserGroupService ser;

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
     *
     * @return
     */
    public CommonObjReturn creatGroup(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response) {
        TsFunctionGroup resultData = null;
        HashMap map = (HashMap) objparam.getData();
        String groupname = map.get("groupname").toString();
        String companyID = map.get("companyID").toString();
        String reatUserName = map.get("reatUserName").toString();
        Integer reatUserID = Integer.valueOf(map.get("reatUserID").toString());
        String result = ser.insertGroup(groupname, companyID, reatUserName, reatUserID);
        if ("1".equals(result)){
            resultData = ser.getGroup(companyID,groupname);
        }
        CommonObjReturn commonObjReturn = new CommonObjReturn();
        commonObjReturn.setData(resultData);
        commonObjReturn.setResult("true");
        commonObjReturn.setResultTime(DateUtils.DateToString(new Date(), DateUtils.formatStr_yyyyMMddHHmmss));
        return commonObjReturn;
    }

    //获取子组的列表
    public CommonObjReturn getGroupList(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response) {
        HashMap map = (HashMap) objparam.getData();
        String sonGroupID = map.get("companyId").toString();
        List<TsFunctionGroup> result = ser.getGroupList(sonGroupID);
        CommonObjReturn commonObjReturn = new CommonObjReturn();
        commonObjReturn.setData(result);
        commonObjReturn.setResult("true");
        commonObjReturn.setResultTime(DateUtils.DateToString(new Date(), DateUtils.formatStr_yyyyMMddHHmmss));
        return commonObjReturn;
    }

    //删除子组
    public CommonObjReturn removeGroup(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response) {
        HashMap map = (HashMap) objparam.getData();
        String sonGroupID = map.get("id").toString();
        JSONObject result = ser.removeGroup(sonGroupID);
        CommonObjReturn commonObjReturn = new CommonObjReturn();
        commonObjReturn.setData(result);
        commonObjReturn.setResult("true");
        commonObjReturn.setResultTime(DateUtils.DateToString(new Date(), DateUtils.formatStr_yyyyMMddHHmmss));
        return commonObjReturn;
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
    private String companyInviteMenber(String phone, String companyID) {
        String result = ser.companyInviteMenber(phone, companyID);

        return result;
    }

    /**
     * 获取公司成员
     *
     * @param
     * @return
     */
    public CommonObjReturn listCompanyMember(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response) {
        TsUser tsUser = JSON.parseObject(JSON.toJSONString(objparam.getData()), TsUser.class);
        JSONObject result = userService.selectUserList(tsUser.getCompanyid());
        CommonObjReturn commonObjReturn = new CommonObjReturn();
        commonObjReturn.setData(result);
        commonObjReturn.setResult("true");
        commonObjReturn.setResultTime(DateUtils.DateToString(new Date(), DateUtils.formatStr_yyyyMMddHHmmss));
        return commonObjReturn;
    }

    //邀请组成员
    public CommonObjReturn invitePeopleGroup(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response) {
        HashMap map = (HashMap) objparam.getData();
        String phone = map.get("phone").toString();
        String companyID = map.get("companyId").toString();
        String groupID = map.get("groupID").toString();
        Object result = userService.invitePeopleGroup(phone, companyID, groupID);
        CommonObjReturn commonObjReturn = new CommonObjReturn();
        commonObjReturn.setData(result);
        commonObjReturn.setResult("true");
        commonObjReturn.setResultTime(DateUtils.DateToString(new Date(), DateUtils.formatStr_yyyyMMddHHmmss));
        return commonObjReturn;
    }

    //获取组成员
    public CommonObjReturn listGroupMember(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response) {
        HashMap map = (HashMap) objparam.getData();
        String groupId = map.get("groupId").toString();
        JSONObject result = userService.listGroupMember(groupId);
        CommonObjReturn commonObjReturn = new CommonObjReturn();
        commonObjReturn.setData(result);
        commonObjReturn.setResult("true");
        commonObjReturn.setResultTime(DateUtils.DateToString(new Date(), DateUtils.formatStr_yyyyMMddHHmmss));
        return commonObjReturn;
    }

}
