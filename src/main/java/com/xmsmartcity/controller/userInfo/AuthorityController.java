package com.xmsmartcity.controller.userInfo;

import com.xmsmartcity.mapper.TsFunctionAuthorityMapper;
import com.xmsmartcity.pojo.*;
import com.xmsmartcity.service.AuthorityListService;
import com.xmsmartcity.service.GroupAuthority;
import com.xmsmartcity.service.UserGroupService;
import com.xmsmartcity.service.UserService;
import com.xmsmartcity.util.DateUtils;
import org.springframework.web.bind.annotation.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by welleast on 2018/2/5.
 */
@SpringBootApplication
@RestController
public class AuthorityController {
    @Autowired
    private UserGroupService groupser;
    @Autowired
    private UserService userSer;

    @Autowired
    private GroupAuthority Authser;

    //获取子组列表+各组的权限
    public CommonObjReturn  getGroupAuthorityList(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response){
        CommonObjReturn commonObjReturn=new CommonObjReturn();
        HashMap map = (HashMap) objparam.getData();
        String sonGroupID = map.get("companyId").toString();
        List<TsFunctionGroup> result = groupser.getGroupList(sonGroupID);
        for (TsFunctionGroup group: result)
        {
            List<TsFunctionAuthority> seleteResule = Authser.selectWithGroupListIDKey(group.getId());
            ArrayList arr = new ArrayList();
            for (TsFunctionAuthority model : seleteResule){
                arr.add(model.getFault());
            }
            group.setAuthorityArr(arr);
        }
        commonObjReturn.setData(result);
        return commonObjReturn;
    }

    //获取组的权限
    public CommonObjReturn getGroupAu(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response)
    {
        HashMap map = (HashMap) objparam.getData();
        Integer groupID = Integer.valueOf(map.get("groupID").toString());
        CommonObjReturn commonObjReturn=new CommonObjReturn();

        List<TsFunctionAuthority> seleteResule = Authser.selectWithGroupListIDKey(groupID);
        ArrayList arr = new ArrayList();
        for (TsFunctionAuthority model : seleteResule){
            arr.add(model.getFault());
        }
        commonObjReturn.setData(arr);
        return commonObjReturn;
    }

    //根据用户ID获取组的信息和权限集合
    public  CommonObjReturn getGroupAuIDWithUserID(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response)
    {
        HashMap map = (HashMap) objparam.getData();
        Integer userID = Integer.valueOf(map.get("userID").toString());
        CommonObjReturn commonObjReturn=new CommonObjReturn();
        TsUser user =  userSer.selectUserById(userID);

        List<TsFunctionAuthority> seleteResule = Authser.selectWithGroupListIDKey(user.getGroupid());
        ArrayList arr = new ArrayList();
        for (TsFunctionAuthority model : seleteResule){
            arr.add(model.getFault());
        }
        commonObjReturn.setData(arr);

        return commonObjReturn;

    }

    //设置组的权限
    public  CommonObjReturn setGroupAu(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response)
    {
        HashMap map = (HashMap) objparam.getData();
        Integer groupID = Integer.valueOf(map.get("groupID").toString());
        Integer companyID =  Integer.valueOf(map.get("companyID").toString());
        ArrayList<Integer> auID = (ArrayList) map.get("auID");
        int deleteReuselt= Authser.deleteGroupWithID(groupID);
        for (Integer auid :auID){
            TsFunctionAuthority model = new TsFunctionAuthority();
            model.setGroupid(groupID);
            model.setFault(auid);
            model.setCompanyid(companyID);
            int insertReuselt = Authser.insert(model);
        }
        CommonObjReturn commonObjReturn=new CommonObjReturn();
        return commonObjReturn;
    }

    //获取权限列表
    @Autowired
    private AuthorityListService auser;
    public  CommonObjReturn getAllList(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response){
        List<TsAuthorityList> result = auser.getAuList();
        for (TsAuthorityList list :result){
           list.key=list.getId();
        }
        CommonObjReturn commonObjReturn=new CommonObjReturn();
        commonObjReturn.setData(result);
        commonObjReturn.setResult("true");
        commonObjReturn.setResultTime(DateUtils.DateToString(new Date(),DateUtils.formatStr_yyyyMMddHHmmss));
        return commonObjReturn;
    }
}
