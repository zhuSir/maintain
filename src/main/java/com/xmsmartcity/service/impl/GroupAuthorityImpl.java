package com.xmsmartcity.service.impl;

import com.xmsmartcity.mapper.BaseDao;
import com.xmsmartcity.mapper.TsFunctionAuthorityMapper;
import com.xmsmartcity.pojo.TsFunctionAuthority;
import com.xmsmartcity.service.GroupAuthority;
import com.xmsmartcity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by welleast on 2018/2/5.
 */
@Service("groupauthority")
public class GroupAuthorityImpl extends BaseServiceImpl<TsFunctionAuthority> implements GroupAuthority {
    public  GroupAuthorityImpl(BaseDao<TsFunctionAuthority> dao){
        super(dao);
    }
    @Autowired
    private TsFunctionAuthorityMapper dao;

    @Override
    public TsFunctionAuthority selectWithConpanyIDKey(Integer id) {
        TsFunctionAuthority rity = dao.selectWithConpanyIDKey(id);

        return rity;
    }
}
