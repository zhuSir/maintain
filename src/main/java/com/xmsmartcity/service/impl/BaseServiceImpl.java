package com.xmsmartcity.service.impl;

import com.xmsmartcity.mapper.BaseDao;

/**
 * Created by zhugw on 2018/1/22 0022.
 */
public class BaseServiceImpl<T> {

    private BaseDao<T> dao;

    public BaseServiceImpl(BaseDao<T> dao){
        this.dao = dao;
    }

    public Integer deleteByPrimaryKey(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    public Integer insert(T record) {
        return dao.insert(record);
    }

    public Integer insertSelective(T record) {
        return dao.insertSelective(record);
    }

    public T selectByPrimaryKey(Integer id) {
        return dao.selectByPrimaryKey(id);
    }

    public Integer updateByPrimaryKeySelective(T record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    public Integer updateByPrimaryKey(T record) {
        return dao.updateByPrimaryKey(record);
    }

}
