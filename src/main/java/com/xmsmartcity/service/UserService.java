package com.xmsmartcity.service;

import com.alibaba.fastjson.JSONObject;
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
    String addUser(TsUser tsUser);

    /*
     * 查询用户
     */
    String selectUser(TsUser tsUser);

    List<Map<String,Object>> selectList(String phone, String name);

    /**
     * 公司Id获取成员
     * @param companyID
     * @return
     */
    List<Map<String,Object>> selectUserList(String companyID);

    /*
    * phone查询用户
    */
    TsUser selectByPhone(String phone);

    //邀请用户
    Object invitePeopleGroup(String phone,String companyID,String groupID);


    /*
    * id查询用户
    */
    TsUser selectUserById(int id);
}
