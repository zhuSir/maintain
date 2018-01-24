package com.xmsmartcity.controller.project;

import com.xmsmartcity.pojo.TpProject;
import com.xmsmartcity.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: EzerXie
 * @Description:
 * @Date: Created on 11:48 2018/1/22
 * @Modified By:
 */

@RestController
@RequestMapping(value = "/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/insert")
    public String insertProject(TpProject project,String date1,String date2){
        projectService.insertProject(project);
        return null;
    }

    @RequestMapping(value = "/delect")
    public String delectProject(int id){
        projectService.delectProject(id);
        return null;
    }

    @RequestMapping(value = "/select")
    public List<TpProject> selectProject(int uId){
        return projectService.selectAllProject(uId);
    }

}
