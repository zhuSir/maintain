package com.xmsmartcity.controller.project;

import com.xmsmartcity.pojo.TpProject;
import com.xmsmartcity.service.ProjectService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public String insertProject(String uId,TpProject project,@Param("startData") String startData, @Param("endDate") String endDate) {
        try {
            if(uId==null||uId.equals("")){
                return "参数错误,创建失败";
            }
            if(project.getName()==null||"".equals(project.getName())){
                return "参数错误,创建失败";
            }
            if(project.getDepId()==null||project.getDepId().equals("")){
                return "参数错误,创建失败";
            }
            if(project.getOwenerUnitId()==null||project.getOwenerUnitId().equals("")){
                return "参数错误,创建失败";
            }
            if(project.getConstructUnitId()==null||project.getConstructUnitId().equals("")){
                return "参数错误,创建失败";
            }
            if(startData==null||startData.equals("")){
                return "参数错误,创建失败";
            }
            if(endDate==null||endDate.equals("")){
                return "参数错误,创建失败";
            }
            if(project.getManagerId()==null||project.getManagerId().equals("")){
                return "参数错误,创建失败";
            }
            if(project.getAuditPersonId()==null||project.getAuditPersonId().equals("")){
                return "参数错误,创建失败";
            }
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Timestamp timestamp = new Timestamp(date.getTime());
            project.setCreateTime(timestamp);
            project.setUpdateTime(timestamp);
            timestamp.setTime(sdf.parse(startData).getTime());
            project.setPlanStartDate(timestamp);
            timestamp.setTime(sdf.parse(endDate).getTime());
            project.setPlanEndDate(timestamp);
            project.setCreatePersonId(Integer.parseInt(uId));
            String s = projectService.insertProject(project);
            if("-1".equals(s)){
                return "创建失败";
            }
            return "创建成功";
        }catch (Exception e){
            return "创建失败";
        }
    }

    @RequestMapping(value = "/delect")
    public String delectProject(int id) {
        projectService.delectProject(id);
        return null;
    }

    @RequestMapping(value = "/update")
    public String updateProject(TpProject project,@Param("startData") String startData, @Param("endDate") String endDate){
        try {
            if(project.getId()<=0){
                return "参数错误,修改失败";
            }
            if(project.getName()==null||"".equals(project.getName())){
                return "参数错误,修改失败";
            }
            if(project.getDepId()==null||project.getDepId().equals("")){
                return "参数错误,修改失败";
            }
            if(project.getOwenerUnitId()==null||project.getOwenerUnitId().equals("")){
                return "参数错误,修改失败";
            }
            if(project.getConstructUnitId()==null||project.getConstructUnitId().equals("")){
                return "参数错误,修改失败";
            }
            if(startData==null||startData.equals("")){
                return "参数错误,修改失败";
            }
            if(endDate==null||endDate.equals("")){
                return "参数错误,修改失败";
            }
            if(project.getManagerId()==null||project.getManagerId().equals("")){
                return "参数错误,修改失败";
            }
            if(project.getAuditPersonId()==null||project.getAuditPersonId().equals("")){
                return "参数错误,修改失败";
            }
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Timestamp timestamp = new Timestamp(date.getTime());
            project.setCreateTime(timestamp);
            project.setUpdateTime(timestamp);
            timestamp.setTime(sdf.parse(startData).getTime());
            project.setPlanStartDate(timestamp);
            timestamp.setTime(sdf.parse(endDate).getTime());
            project.setPlanEndDate(timestamp);
            String s = projectService.updateProject(project);
            if("-1".equals(s)){
                return "修改失败";
            }
            return "修改成功";
        }catch (Exception e){
            return "修改失败";
        }
    }

    @RequestMapping(value = "/select")
    public List<TpProject> selectProject(@NotNull String uId) {
        if (uId != null) {
            try {
                int userId = Integer.parseInt(uId);
                List<TpProject> tpProjects = projectService.selectAllProject(userId);
                return tpProjects;
            }catch (Exception e){
                return new ArrayList<TpProject>();
            }
        } else {
            return new ArrayList<TpProject>();
        }
    }

}
