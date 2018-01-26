package com.xmsmartcity.service;

import com.xmsmartcity.pojo.TeEquipType;

import java.util.List;

public interface EquipTypeService extends BaseService<TeEquipType>{

    /**
     * 查询设备列表
     * @return
     */
    public List<TeEquipType> selectEquipTypeList();

}
