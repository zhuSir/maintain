package com.xmsmartcity.controller.userInfo;


import com.xmsmartcity.pojo.TsFunctionGroup;
import com.xmsmartcity.service.UserGroupService;
import com.xmsmartcity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import com.xmsmartcity.pojo.TsFunctionGroup;
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
    UserService userService;

    /**
     * 创建公司
     * @return
     */
    @RequestMapping(value="/user/creatcompany",method = RequestMethod.POST)
    private String creatGroup(String companyName,String reatUserName,String reatUserID){

        String resault =  ser.creatGroup(companyName,reatUserName,reatUserID);

        return resault;
    }

    /**
     * 创建组
     * @return
     */
    @RequestMapping(value="/user/creatGroup",method = RequestMethod.POST)
    private String creatGroup(String groupname,String companyID,String reatUserName,String reatUserID){

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
    @RequestMapping(value="/user/getCompanyInfo",method = RequestMethod.POST)
    private TsFunctionGroup getcompanyInfo(String companyID){

        TsFunctionGroup result  = ser.getcompanyInfo(companyID);
        return result;
    }

    @GetMapping(value = "/user/companyInviteMember")
    private String companyInviteMenber(String phone,String companyID){
        String  result = ser.companyInviteMenber(phone,companyID);
        return result;
    }

    /**
     * 获取公司成员
     * @param companyID
     * @return
     */
    @RequestMapping(value="/user/companyMemberList",method = RequestMethod.POST)
    private String listCompanyMember(String companyID){
        String result = userService.selectUserList(companyID);
        return result;
    }

    //邀请组成员
    @RequestMapping(value = "/user/invitePeopleGroup",method = RequestMethod.POST)
    public Object invitePeopleGroup(String phone,String companyID,String groupID){

        Object  result = userService.invitePeopleGroup(phone,companyID,groupID);
        return result;
    }

}
