package com.xmsmartcity.mapper;

/**
 * Created by zhugw on 2018/1/22 0022.
 */
public interface BaseDao<T> {
    int deleteByPrimaryKey(Integer id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
