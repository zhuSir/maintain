package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TpProject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TpProjectMapper extends BaseDao<TpProject>{
    int deleteByPrimaryKey(Integer id);

    int insert(TpProject record);

    int insertSelective(TpProject record);

    TpProject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TpProject record);

    int updateByPrimaryKey(TpProject record);

    List<TpProject> selectProjectByName(String name);

    List<TpProject> selectAllProject();

}