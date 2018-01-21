package com.xmsmartcity.userinfo.Service;

import com.xmsmartcity.userinfo.Mapper.Entity.Result;
import com.xmsmartcity.mapper.TsUserMapper;
import com.xmsmartcity.pojo.TsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lingyun on 2018/1/19.
 */

@RestController
@RequestMapping(value = "/dweibao")

public class UserService {


    @Autowired
    TsUserMapper userMapper;

    @RequestMapping(value = "/user/Login" ,method = RequestMethod.POST)
    public Result userLogin(@RequestParam("phone") String phone, @RequestParam("password") String password){

        TsUser user = userMapper.selectByPrimaryKey(phone);
        if(!user.getMobilephone().equals(phone)){//如果没有电话号码提示未注册
            return ResultInfo.responseFlase(101,"账号未注册");
        }else
        {
            if(user.getPassword().equals(password))//如果密码错了
            {
                return ResultInfo.responseFlase(102,"账号或者密码错误");

            }else//登入成功=====
            {
                return ResultInfo.responseSucess(user);
            }
        }
    }


}
