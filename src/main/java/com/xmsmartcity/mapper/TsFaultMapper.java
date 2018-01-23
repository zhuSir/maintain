package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsFault;

import java.util.List;
import java.util.Map;

public interface TsFaultMapper extends BaseDao<TsFault>{
    List<Map> selectList();
}