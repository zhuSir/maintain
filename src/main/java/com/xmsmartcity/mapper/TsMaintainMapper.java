package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsMaintain;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TsMaintainMapper extends BaseDao<TsMaintain>{
    List<TsMaintain> selectList(Integer userId);
}