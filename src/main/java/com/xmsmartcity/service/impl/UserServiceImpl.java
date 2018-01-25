package com.xmsmartcity.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.xmsmartcity.mapper.BaseDao;
import com.xmsmartcity.mapper.TsUserMapper;
import com.xmsmartcity.pojo.TsUser;
import com.xmsmartcity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangzhifu on 2018/1/23.
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<TsUser> implements UserService {
    public UserServiceImpl(BaseDao<TsUser> dao) {
        super(dao);
    }

    @Autowired
    private TsUserMapper dao;

    @Override
    public String addUser(TsUser tsUser) {
        JSONObject json = new JSONObject();
        if (null == tsUser || "".equals(tsUser)) {//参数不存在
            json.put("code", 1);
            json.put("info", "用户名或手机号不存在");
        } else {//参数存在，判断是否重复创建
            String phone = tsUser.getMobilephone();
            TsUser tsUserReturn = dao.selectUser(phone);
            if (tsUserReturn == null || StringUtils.isEmpty(tsUserReturn.getMobilephone())) {//未注册
                int insert = dao.insertSelective(tsUser);
                if (insert != 0) {
                    json.put("code", 0);
                    json.put("info", "注册成功");
                } else {
                    json.put("code", 1);
                    json.put("info", "注册失败");
                }
            } else {//已注册
                json.put("code", 1);
                json.put("info", "该用户已注册");
            }
        }
        return json.toJSONString();
    }

    @Override
    public String selectUser(TsUser tsUser) {
        JSONObject json = new JSONObject();
        if (null == tsUser || "".equals(tsUser)) {//参数不存在
            json.put("code", 1);
            json.put("info", "手机号或密码不存在");
        } else {//参(String phone,String companyID,String groupID)数存在，判断是否重复创建
            String phone = tsUser.getMobilephone();
            String password = tsUser.getPassword();
            TsUser tsUserReturn = dao.selectUser(phone);
            if (tsUserReturn != null&&phone.equals(tsUserReturn.getMobilephone())&& password.equals(tsUserReturn.getPassword())){
                json.put("code", 0);
                json.put("data",tsUserReturn);
                json.put("info", "登陆成功");
            }else {
                json.put("code", 1);
                json.put("info", "手机号或密码错误");
            }
        }
        return json.toJSONString();
    }

    @Override
    public List<Map<String, Object>> selectList(String phone,String name) {
        List<Map<String,Object>> result = dao.selectList(phone,name);
        return result;
    }

    @Override
    public TsUser selectByPhone(String phone) {
        return dao.selectUser(phone);
    }



    //邀请用户 进入到组
    @Override
    public Object invitePeopleGroup(String phone, String companyID, String groupID) {

        JSONObject json = new JSONObject();
    if (phone==null|| companyID==null|| groupID==null)
    {
        json.put("code", 1);
        json.put("info", "缺少参数");
    }else
    {
        TsUser tsUserReturn = dao.selectUser(phone);
        if (tsUserReturn==null)
        {
            json.put("code", 0);
            json.put("info", "没有此用户");
        }else if(tsUserReturn.getCompanyid()>0)
        {
            json.put("code", 0);
            json.put("info", "用户已有公司");
        }
        else
        {
            int result = dao.invitePeopleGroup(phone,companyID,groupID);
            if (result==1)
            {
                json.put("code", 0);
                json.put("info", "邀请成功");
            }
            else
            {
                json.put("code", 1);
                json.put("info", "邀请失败");
            }
        }



    }


        return json;
    }



    @Override
    public TsUser selectUserById(int userId) {
        return dao.selectUserById(userId);
    }
}
