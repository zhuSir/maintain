package com.xmsmartcity.service.impl;

import com.xmsmartcity.mapper.BaseDao;
import com.xmsmartcity.mapper.TeEquipMapper;
import com.xmsmartcity.mapper.TsMaintainMapper;
import com.xmsmartcity.pojo.TeEquip;
import com.xmsmartcity.pojo.TsMaintain;
import com.xmsmartcity.service.EquipService;
import com.xmsmartcity.service.MaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipServiceImpl extends BaseServiceImpl<TeEquip> implements EquipService {

    public EquipServiceImpl(BaseDao<TeEquip> dao) {
        super(dao);
    }

    @Autowired
    private TeEquipMapper dao;

    @Override
    public List<TeEquip> selectEquipList() {
        List<TeEquip> result = dao.selectEquipList();
        return result;
    }

}