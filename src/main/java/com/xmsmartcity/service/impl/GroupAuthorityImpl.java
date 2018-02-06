package com.xmsmartcity.service.impl;

import com.xmsmartcity.mapper.BaseDao;
import com.xmsmartcity.mapper.TsFunctionAuthorityMapper;
import com.xmsmartcity.pojo.TsAuthorityList;
import com.xmsmartcity.pojo.TsFunctionAuthority;
import com.xmsmartcity.service.GroupAuthority;
import com.xmsmartcity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List selectWithGroupListIDKey(Integer id) {
        List rity = dao.selectWithGroupListIDKey(id);

        return rity;
    }

    @Override
    public int settingGroupAu(Integer groupId, Integer auId) {
        return 0;
    }

    @Override
    public TsAuthorityList seleteWithGroupIdAu(Integer groupId, Integer auId) {
        return null;
    }

    @Override
    public int deleteGroupWithID(Integer id) {
        int rity = dao.deleteGroupWithID(id);
        return rity;
    }

    @Override
    public int insertGroupWithID(TsFunctionAuthority record) {
        return 0;
    }


}
