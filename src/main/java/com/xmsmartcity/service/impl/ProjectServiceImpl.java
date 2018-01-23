package com.xmsmartcity.service.impl;

import com.xmsmartcity.mapper.BaseDao;
import com.xmsmartcity.mapper.TpProjectMapper;
import com.xmsmartcity.pojo.TpProject;
import com.xmsmartcity.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: EzerXie
 * @Description:
 * @Date: Created on 14:50 2018/1/22
 * @Modified By:
 */
@Service("projectService")
public class ProjectServiceImpl extends BaseServiceImpl<TpProject> implements ProjectService {

    public ProjectServiceImpl(BaseDao<TpProject> dao) {
        super(dao);
    }

    @Autowired
    private TpProjectMapper dao;

    @Override
    public String insertProject(TpProject project) {
        int insert = dao.insert(project);
        return insert + "";
    }

    @Override
    public String delectProject(int pId) {
        int delete = dao.deleteByPrimaryKey(pId);
        return delete + "";
    }

    @Override
    public String updateProject(TpProject project) {
        int update = dao.updateByPrimaryKey(project);
        return update + "";
    }

    @Override
    public List<TpProject> selectProjectByName(String name) {
        List<TpProject> tpProjects;
        if (null == name || "".equals(name)) {
            tpProjects = dao.selectAllProject();
        } else {
            tpProjects = dao.selectProjectByName(name);
        }
        return tpProjects;
    }
}
