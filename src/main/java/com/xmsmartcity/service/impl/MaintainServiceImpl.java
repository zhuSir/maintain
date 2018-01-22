package com.xmsmartcity.service.impl;

import com.xmsmartcity.mapper.BaseDao;
import com.xmsmartcity.mapper.TsMaintainMapper;
import com.xmsmartcity.pojo.TsMaintain;
import com.xmsmartcity.service.MaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Owner on 2018/1/22 0022.
 */
@Service("maintainService")
public class MaintainServiceImpl extends BaseServiceImpl<TsMaintain> implements MaintainService {

    public MaintainServiceImpl(BaseDao<TsMaintain> dao) {
        super(dao);
    }

    @Autowired
    private TsMaintainMapper dao;

    @Override
    public List<TsMaintain> selectList() {
        List<TsMaintain> result = dao.selectList(1);
        return result;
    }

}