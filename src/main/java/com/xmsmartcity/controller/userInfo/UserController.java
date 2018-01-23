package com.xmsmartcity.controller.userInfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户操作
 * Created by zzf on 2018/1/19 0019.
 */
@Controller
public class UserController {

    /**
     * 注册接口
     * @return
     */
    @RequestMapping(value="/register",method = RequestMethod.POST)
    private String register(){
        return "json";
    }




}
