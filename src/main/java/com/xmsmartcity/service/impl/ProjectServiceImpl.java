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
        int insert = dao.insertSelective(project);
        if (insert == -1)
            return insert + "";
        else
            return project.getId() + "";
    }

    public TpProject insertProject2(TpProject project){
        int insert = dao.insertSelective(project);
        if (insert == -1)
            return null;
        else
            return project;
    }

    @Override
    public String delectProject(int pId) {
        int delete = dao.deleteByPrimaryKey(pId);
        return delete + "";
    }

    @Override
    public String updateProject(TpProject project) {
        int update = dao.updateByPrimaryKeySelective(project);
        return update + "";
    }

    @Override
    public List<TpProject> selectAllProject(int id) {
        List<TpProject> tpProjects = dao.selectAllProject(id);
        return tpProjects;
    }


}
