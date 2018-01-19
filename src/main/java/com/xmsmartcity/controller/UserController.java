package com.xmsmartcity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Owner on 2018/1/19 0019.
 */
@Controller
public class UserController {

    //我也参与了这个项目
    @RequestMapping(value="/user",method = RequestMethod.GET)
    @ResponseBody
    private String user(){
        return "json";
    }

    private String xixi(){
        return "";
    }
    //测试
    //账号bonelvxin@163.com提交测试
}
