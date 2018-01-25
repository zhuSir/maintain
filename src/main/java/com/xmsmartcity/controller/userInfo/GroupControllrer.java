package com.xmsmartcity.controller.userInfo;


import com.alibaba.fastjson.JSONObject;
import com.xmsmartcity.mapper.TsUserMapper;
import com.xmsmartcity.pojo.TsFunctionGroup;
import com.xmsmartcity.pojo.TsUser;
import com.xmsmartcity.service.UserGroupService;
import com.xmsmartcity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by welleast on 2018/1/23.
 */
@SpringBootApplication
@RestController
public class GroupControllrer {

    @Autowired
    private   UserGroupService ser;




    /**
     * 创建组
     * @return
     */
    @RequestMapping(value="user/creatGroup",method = RequestMethod.POST)
    private String creatGroup(String groupname){

         String resault =  ser.insertGroup(groupname);

        return resault;
    }


    //获取子组的列表
    @RequestMapping(value="/user/getGroupList",method = RequestMethod.POST)
    private List getGroupList(String sonGroupID){

        List<TsFunctionGroup> result  = ser.getGroupList(sonGroupID);
        return result;
    }

    //获取公司的详情
    @RequestMapping(value="/user/getCompanyInfo",method = RequestMethod.POST)
    private TsFunctionGroup getcompanyInfo(String companyID){

        TsFunctionGroup result  = ser.getcompanyInfo(companyID);
        return result;
    }

    @GetMapping(value = "/user/companyInviteMember")
    private String companyInviteMenber(String phone,String companyID)
    {
        String  result = ser.companyInviteMenber(phone,companyID);

        return result;
    }

}
