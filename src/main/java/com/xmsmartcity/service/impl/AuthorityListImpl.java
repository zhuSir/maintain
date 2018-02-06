package com.xmsmartcity.service.impl;

import com.xmsmartcity.mapper.TsAuthorityListMapper;
import com.xmsmartcity.pojo.TsAuthorityList;
import com.xmsmartcity.service.AuthorityListService;
import com.xmsmartcity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xmsmartcity.mapper.BaseDao;

import java.util.List;

/**
 * Created by welleast on 2018/2/5.
 */

@Service("authoritylistservice")
public class AuthorityListImpl extends BaseServiceImpl<TsAuthorityList> implements AuthorityListService {
    public AuthorityListImpl(BaseDao<TsAuthorityList> dao) {
        super(dao);
    }

    @Autowired

    private TsAuthorityListMapper dao;
    @Override
    public List<TsAuthorityList> getAuList() {
        List result = dao.getAuList();
        return result;
    }
}
