package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsFault;

public interface TsFaultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TsFault record);

    int insertSelective(TsFault record);

    TsFault selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TsFault record);

    int updateByPrimaryKey(TsFault record);
}