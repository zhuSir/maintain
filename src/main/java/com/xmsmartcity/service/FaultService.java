package com.xmsmartcity.service;

import com.xmsmartcity.pojo.TsFault;

import java.util.List;

/**
 * Created by zhugw on 2018/1/23 0023.
 */
public interface FaultService extends BaseService<TsFault>{

    public List<List<Object>>selectList();

}
