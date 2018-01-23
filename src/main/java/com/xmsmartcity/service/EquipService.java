package com.xmsmartcity.service;

import com.xmsmartcity.pojo.TeEquip;
import com.xmsmartcity.pojo.TsMaintain;

import java.util.List;

public interface EquipService extends BaseService<TeEquip>{

    public List<TeEquip> selectEquipList();

}
