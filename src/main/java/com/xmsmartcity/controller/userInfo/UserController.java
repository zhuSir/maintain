package com.xmsmartcity.controller.userInfo;

import com.xmsmartcity.pojo.CommonObjParam;
import com.xmsmartcity.pojo.CommonObjReturn;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Owner on 2018/1/19 0019.
 */
@Controller
public class UserController {

    //我也参与了这个项目
    @RequestMapping(value="/user")
//    @ResponseBody
    public String user(){
        return "json";
    }

    private String xixi(){
        return "";
    }
    //测试
    //账号bonelvxin@163.com提交测试
    //张莹--------------------测试代码合并

    @ResponseBody
    public CommonObjReturn cbyest(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response){
         return new CommonObjReturn();
    }
    private String laokiTest(){
        return "lly";
    }


}
