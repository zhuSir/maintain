package com.xmsmartcity.controller.project;

import com.alibaba.fastjson.JSON;
import com.xmsmartcity.pojo.*;
import com.xmsmartcity.service.FaultService;
import com.xmsmartcity.service.ProjectService;
import com.xmsmartcity.util.DateUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    FaultService faultService;

    @ResponseBody
    public CommonObjReturn saveProject(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response) {
        ProjectRequestBean projectRequestBean = JSON.parseObject(JSON.toJSONString(objparam.getData()), ProjectRequestBean.class);
        CommonObjReturn commonObjReturn=new CommonObjReturn();
        try {
            if (projectRequestBean.getuId() == null || projectRequestBean.getuId().equals("")) {
                commonObjReturn.setReason("参数错误,创建失败");
                commonObjReturn.setResult("false");
                return commonObjReturn;
            }
            if (projectRequestBean.getName() == null || "".equals(projectRequestBean.getName())) {
                commonObjReturn.setReason("参数错误,创建失败");
                commonObjReturn.setResult("false");
                return commonObjReturn;
            }
            if (projectRequestBean.getDepId() == null || projectRequestBean.getDepId().equals("")) {
                commonObjReturn.setReason("参数错误,创建失败");
                commonObjReturn.setResult("false");
                return commonObjReturn;
            }
            if (projectRequestBean.getOwenerUnitId() == null || projectRequestBean.getOwenerUnitId().equals("")) {
                commonObjReturn.setReason("参数错误,创建失败");
                commonObjReturn.setResult("false");
                return commonObjReturn;
            }
            if (projectRequestBean.getConstructUnitId() == null || projectRequestBean.getConstructUnitId().equals("")) {
                commonObjReturn.setReason("参数错误,创建失败");
                commonObjReturn.setResult("false");
                return commonObjReturn;
            }
            if (projectRequestBean.getStartData() == null || projectRequestBean.getStartData().equals("")) {
                commonObjReturn.setReason("参数错误,创建失败");
                commonObjReturn.setResult("false");
                return commonObjReturn;
            }
            if (projectRequestBean.getEndDate() == null || projectRequestBean.getEndDate().equals("")) {
                commonObjReturn.setReason("参数错误,创建失败");
                commonObjReturn.setResult("false");
                return commonObjReturn;
            }
            if (projectRequestBean.getManagerId() == null || projectRequestBean.getManagerId().equals("")) {
                commonObjReturn.setReason("参数错误,创建失败");
                commonObjReturn.setResult("false");
                return commonObjReturn;
            }
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Timestamp timestamp = new Timestamp(date.getTime());
            TpProject project = JSON.parseObject(JSON.toJSONString(objparam.getData()), TpProject.class);
            project.setCreateTime(timestamp);
            project.setUpdateTime(timestamp);
            project.setPlanStartDate(new Timestamp(sdf.parse(projectRequestBean.getStartData()).getTime()));
            project.setPlanEndDate(new Timestamp(sdf.parse(projectRequestBean.getEndDate()).getTime()));
            project.setCreatePersonId(projectRequestBean.getuId());
            TpProject tpProject = projectService.insertProject2(project);
            if (tpProject==null) {
                commonObjReturn.setReason("服务器错误,创建失败");
                commonObjReturn.setResult("false");
                return commonObjReturn;
            }
            commonObjReturn.setResult("true");
            commonObjReturn.setData(tpProject);
            return commonObjReturn;
        } catch (Exception e) {
            commonObjReturn.setReason("参数错误,创建失败");
            commonObjReturn.setResult("false");
            return commonObjReturn;
        }
    }

    @ResponseBody
    public CommonObjReturn deleteProject(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response) {
        ProjectRequestBean projectRequestBean = JSON.parseObject(JSON.toJSONString(objparam.getData()), ProjectRequestBean.class);
        CommonObjReturn commonObjReturn=new CommonObjReturn();
        TpProject tpProject = projectService.selectByPrimaryKey(projectRequestBean.getId());
        if(tpProject==null){
            commonObjReturn.setReason("无此项目");
            commonObjReturn.setResult("false");
            return commonObjReturn;
        }
        if (tpProject.getCreatePersonId() != projectRequestBean.getuId()) {
            commonObjReturn.setReason("无删除权限");
            commonObjReturn.setResult("false");
            return commonObjReturn;
        }
        String delectResult = "";
        delectResult = projectService.delectProject(projectRequestBean.getId());
        if ("-1".equals(delectResult)) {
            commonObjReturn.setReason("删除失败");
            commonObjReturn.setResult("false");
            return commonObjReturn;
        }
        commonObjReturn.setResult("true");
        commonObjReturn.setReason("删除成功");
        return commonObjReturn;
    }

    @ResponseBody
    public CommonObjReturn updateProject(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response) {
        ProjectRequestBean projectRequestBean = JSON.parseObject(JSON.toJSONString(objparam.getData()), ProjectRequestBean.class);
        CommonObjReturn commonObjReturn=new CommonObjReturn();
        try {
            if (projectRequestBean.getuId() ==null) {
                commonObjReturn.setReason("参数错误");
                commonObjReturn.setResult("false");
                return commonObjReturn;
            }
            if (projectRequestBean.getId()==null) {
                commonObjReturn.setReason("参数错误");
                commonObjReturn.setResult("false");
                return commonObjReturn;
            }
            TpProject project = JSON.parseObject(JSON.toJSONString(objparam.getData()), TpProject.class);
            TpProject tpProject = projectService.selectByPrimaryKey(project.getId());
            if(tpProject==null){
                commonObjReturn.setReason("无此项目");
                commonObjReturn.setResult("false");
                return commonObjReturn;
            }
            if (tpProject.getCreatePersonId() != projectRequestBean.getuId()) {
                commonObjReturn.setReason("无修改权限");
                commonObjReturn.setResult("false");
                return commonObjReturn;
            }
            if (project == null) {
                commonObjReturn.setReason("参数错误,修改失败");
                commonObjReturn.setResult("false");
                return commonObjReturn;
            }
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Timestamp timestamp = new Timestamp(date.getTime());
            project.setCreateTime(timestamp);
            project.setUpdateTime(timestamp);
            if (projectRequestBean.getStartData() != null) {
                project.setPlanStartDate(new Timestamp(sdf.parse(projectRequestBean.getStartData()).getTime()));
            }
            if (projectRequestBean.getEndDate() != null) {
                project.setPlanEndDate(new Timestamp(sdf.parse(projectRequestBean.getEndDate()).getTime()));
            }
            String s = projectService.updateProject(project);
            if ("-1".equals(s)) {
                commonObjReturn.setReason("服务器错误,修改失败");
                commonObjReturn.setResult("false");
                return commonObjReturn;
            }
            commonObjReturn.setResult("true");
            commonObjReturn.setData(projectService.selectByPrimaryKey(project.getId()));
            return commonObjReturn;
        } catch (Exception e) {
            commonObjReturn.setReason("参数错误,修改失败");
            commonObjReturn.setResult("false");
            return commonObjReturn;
        }
    }

    @ResponseBody
    public CommonObjReturn listProject(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response) {
        Integer uId= JSON.parseObject(JSON.toJSONString(objparam.getData()),ProjectRequestBean.class).getuId();
        CommonObjReturn commonObjReturn=new CommonObjReturn();
        commonObjReturn.setResultTime(DateUtils.DateToString(new Date(),DateUtils.formatStr_yyyyMMddHHmmss));
        if (uId != null) {
            try {
                List<TpProject> tpProjects = projectService.selectAllProject(uId);
                commonObjReturn.setResult("true");
                commonObjReturn.setData(tpProjects);
                return commonObjReturn;
            } catch (Exception e) {
                commonObjReturn.setResult("false");
                commonObjReturn.setReason("服务器错误");
                return commonObjReturn;
            }
        } else {
            commonObjReturn.setResult("false");
            commonObjReturn.setReason("参数错误");
            return commonObjReturn;
        }
    }

}
