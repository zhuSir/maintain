package com.xmsmartcity.controller.userInfo;

import com.xmsmartcity.pojo.TsUser;
import com.xmsmartcity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户操作
 * Created by zzf on 2018/1/19 0019.
 */
@RestController
@RequestMapping(value = "/userinfo")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 注册接口
     * @return
     */
    @RequestMapping(value="/register",method = RequestMethod.POST)
    private String register(TsUser tsUser){
        String result = userService.addUser(tsUser);
        return result;
    }

    /**
     * 登陆接口
     * @return
     */
    @RequestMapping(value="/login",method = RequestMethod.POST)
    private String login(TsUser tsUser){
        String result = userService.selectUser(tsUser);
        return result;
    }

}
