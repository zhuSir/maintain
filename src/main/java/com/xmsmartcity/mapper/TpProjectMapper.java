package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TpProject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TpProjectMapper extends BaseDao<TpProject>{

    List<TpProject> selectProjectByName(String name);

    List<TpProject> selectAllProject(int uId);

}