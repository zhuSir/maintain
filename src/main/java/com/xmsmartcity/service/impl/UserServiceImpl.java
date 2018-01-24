package com.xmsmartcity.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.xmsmartcity.mapper.BaseDao;
import com.xmsmartcity.mapper.TsUserMapper;
import com.xmsmartcity.pojo.TsUser;
import com.xmsmartcity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
            json.put("code",1);
            json.put("info","用户名或手机号不存在");
        } else {//参数存在，判断是否重复创建
            String phone = tsUser.getMobilephone();
            TsUser tsUserReturn = dao.selectUser(phone);
            if (tsUserReturn == null || StringUtils.isEmpty(tsUserReturn.getMobilephone())){//未注册
                int insert = dao.insertSelective(tsUser);
                if (insert!=0){
                    json.put("code",0);
                    json.put("info","注册成功");
                }else {
                    json.put("code",1);
                    json.put("info","注册失败");
                }
            }else {//已注册
                json.put("code",1);
                json.put("info","该用户已注册");
            }
        }
        return json.toJSONString();
    }
}
