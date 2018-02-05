package com.xmsmartcity.controller.userInfo;

import com.xmsmartcity.pojo.CommonObjParam;
import com.xmsmartcity.pojo.CommonObjReturn;
import com.xmsmartcity.pojo.TsFunctionGroup;
import com.xmsmartcity.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    //获取子组列表
    public CommonObjReturn  getGroupAuthorityList(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response){
        CommonObjReturn commonObjReturn=new CommonObjReturn();
        HashMap map = (HashMap) objparam.getData();
        String sonGroupID = map.get("companyId").toString();
        List<TsFunctionGroup> result = groupser.getGroupList(sonGroupID);
        for (TsFunctionGroup group: result)
        {


        }



        return commonObjReturn;

    }

}
