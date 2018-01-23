package com.xmsmartcity.service.impl;


import com.xmsmartcity.mapper.BaseDao;
import com.xmsmartcity.mapper.TsUserMapper;
import com.xmsmartcity.pojo.TsUser;
import com.xmsmartcity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public String addUser() {
        return null;
    }
}
