package com.xmsmartcity.service;

import com.xmsmartcity.pojo.TsUser;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangzhifu on 2018/1/23.
 */
public interface UserService extends BaseService<TsUser> {
    /*
     * 添加用户
     */
    public String addUser(TsUser tsUser);

    /*
     * 查询用户
     */
    public String selectUser(TsUser tsUser);

    public List<Map<String,Object>> selectList(String phone,String name);
}
