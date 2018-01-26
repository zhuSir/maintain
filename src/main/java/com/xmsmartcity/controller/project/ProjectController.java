package com.xmsmartcity.controller.project;

import com.xmsmartcity.pojo.BaseResponse;
import com.xmsmartcity.pojo.TpProject;
import com.xmsmartcity.service.FaultService;
import com.xmsmartcity.service.ProjectService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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

    @Autowired
    FaultService faultService;

    @RequestMapping(value = "/insert")
    public BaseResponse<TpProject> insertProject(String uId,TpProject project,@Param("startData") String startData, @Param("endDate") String endDate) {
        BaseResponse<TpProject> baseResponse = new BaseResponse<>();
        try {
            if(uId==null||uId.equals("")){
                baseResponse.setInfo("参数错误,创建失败");
                return baseResponse;
            }
            if(project.getName()==null||"".equals(project.getName())){
                baseResponse.setInfo("参数错误,创建失败");
                return baseResponse;
            }
            if(project.getDepId()==null||project.getDepId().equals("")){
                baseResponse.setInfo("参数错误,创建失败");
                return baseResponse;
            }
            if(project.getOwenerUnitId()==null||project.getOwenerUnitId().equals("")){
                baseResponse.setInfo("参数错误,创建失败");
                return baseResponse;
            }
            if(project.getConstructUnitId()==null||project.getConstructUnitId().equals("")){
                baseResponse.setInfo("参数错误,创建失败");
                return baseResponse;
            }
            if(startData==null||startData.equals("")){
                baseResponse.setInfo("参数错误,创建失败");
                return baseResponse;
            }
            if(endDate==null||endDate.equals("")){
                baseResponse.setInfo("参数错误,创建失败");
                return baseResponse;
            }
            if(project.getManagerId()==null||project.getManagerId().equals("")){
                baseResponse.setInfo("参数错误,创建失败");
                return baseResponse;
            }
            if(project.getAuditPersonId()==null||project.getAuditPersonId().equals("")){
                baseResponse.setInfo("参数错误,创建失败");
                return baseResponse;
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
                baseResponse.setInfo("服务器错误,创建失败");
                return baseResponse;
            }
            baseResponse.setCode(Integer.parseInt(s));
            baseResponse.setData(project);
            return baseResponse;
        }catch (Exception e){
            baseResponse.setInfo("参数错误,创建失败");
            return baseResponse;
        }
    }

    @RequestMapping(value = "/delect")
    public String delectProject(int id) {
        String delectResult = "";
        delectResult = projectService.delectProject(id);
        return delectResult;
    }

    @RequestMapping(value = "/update")
    public BaseResponse<TpProject> updateProject(TpProject project,@Param("startData") String startData, @Param("endDate") String endDate){
        BaseResponse<TpProject> baseResponse = new BaseResponse<>();
        try {
            if(project.getId()<=0){
                baseResponse.setInfo("参数错误,修改失败");
                return baseResponse;
            }
            if(project.getName()==null||"".equals(project.getName())){
                baseResponse.setInfo("参数错误,修改失败");
                return baseResponse;
            }
            if(project.getDepId()==null||project.getDepId().equals("")){
                baseResponse.setInfo("参数错误,修改失败");
                return baseResponse;
            }
            if(project.getOwenerUnitId()==null||project.getOwenerUnitId().equals("")){
                baseResponse.setInfo("参数错误,修改失败");
                return baseResponse;
            }
            if(project.getConstructUnitId()==null||project.getConstructUnitId().equals("")){
                baseResponse.setInfo("参数错误,修改失败");
                return baseResponse;
            }
            if(startData==null||startData.equals("")){
                baseResponse.setInfo("参数错误,修改失败");
                return baseResponse;
            }
            if(endDate==null||endDate.equals("")){
                baseResponse.setInfo("参数错误,修改失败");
                return baseResponse;
            }
            if(project.getManagerId()==null||project.getManagerId().equals("")){
                baseResponse.setInfo("参数错误,修改失败");
                return baseResponse;
            }
            if(project.getAuditPersonId()==null||project.getAuditPersonId().equals("")){
                baseResponse.setInfo("参数错误,修改失败");
                return baseResponse;
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
                baseResponse.setInfo("服务器错误,修改失败");
                return baseResponse;
            }
            baseResponse.setCode(1);
            baseResponse.setData(project);
            return baseResponse;
        }catch (Exception e){
            baseResponse.setInfo("参数错误,修改失败");
            return baseResponse;
        }
    }

    @RequestMapping(value = "/select")
    public BaseResponse<List<TpProject>> selectProject(@NotNull String uId) {
        BaseResponse<List<TpProject>> listBaseResponse = new BaseResponse<>();
        if (uId != null) {
            try {
                int userId = Integer.parseInt(uId);
                List<TpProject> tpProjects = projectService.selectAllProject(userId);
                listBaseResponse.setCode(1);
                listBaseResponse.setData(tpProjects);
                return listBaseResponse;
            }catch (Exception e){
                listBaseResponse.setInfo("服务器错误");
                return listBaseResponse;
            }
        } else {
            listBaseResponse.setInfo("参数错误");
            return listBaseResponse;
        }
    }

}
