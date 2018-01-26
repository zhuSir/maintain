package com.xmsmartcity.service.impl;

import com.xmsmartcity.mapper.BaseDao;
import com.xmsmartcity.mapper.TeEquipTypeMapper;
import com.xmsmartcity.pojo.TeEquipType;
import com.xmsmartcity.service.EquipTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipTypeServiceImpl extends BaseServiceImpl<TeEquipType> implements EquipTypeService {

    public EquipTypeServiceImpl(BaseDao<TeEquipType> dao) {
        super(dao);
    }

    @Autowired
    private TeEquipTypeMapper dao;

    @Override
    public List<TeEquipType> selectEquipTypeList() {
        List<TeEquipType> result = dao.selectEquipTypeList();
        return result;
    }

}