package com.xmsmartcity.service;

import com.xmsmartcity.pojo.TsMaintain;

import java.util.List;

/**
 * Created by Owner on 2018/1/22 0022.
 */
public interface MaintainService extends BaseService<TsMaintain>{

    public List<TsMaintain> selectList();
}
