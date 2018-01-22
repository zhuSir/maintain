package com.xmsmartcity.service;

/**
 * Created by zhugw on 2018/1/22 0022.
 */
public interface BaseService<T> {
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(T record);

    Integer insertSelective(T record);

    T selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(T record);

    Integer updateByPrimaryKey(T record);

}
