package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TeEquip;
import java.util.List;

public interface TeEquipMapper extends BaseDao<TeEquip> {

    List<TeEquip> selectEquipList();

}