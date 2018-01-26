package com.xmsmartcity.controller.userInfo;

import com.xmsmartcity.pojo.TsUser;
import com.xmsmartcity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    /**
     * id获取用户接口
     * @return
     */
    @RequestMapping(value="/getUserById",method = RequestMethod.POST)
    private TsUser getUserById(String userId){
        Integer id = Integer.valueOf(userId);
        TsUser result = userService.selectUserById(id);
        return result;
    }

    @GetMapping("/list")
    public List selectList(String phone,String name){
        List<Map<String,Object>> res = userService.selectList(phone,name);
        return res;
    }

    /**
     * 用户手机查询名称接口
     * @return
     */
    @RequestMapping(value="/byphone")
    public TsUser selectById(String phone){
        TsUser result = userService.selectByPhone(phone);
        return result;
    }

    /**
     * id获取移除公司
     * @return
     */
    @RequestMapping(value="/deleteGroupUser",method = RequestMethod.POST)
    private String deleteGroupUser(String userId){
        Integer id = Integer.valueOf(userId);
        String result = userService.deleteGroupUser(id);
        return result;
    }



}
