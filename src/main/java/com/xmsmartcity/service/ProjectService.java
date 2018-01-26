package com.xmsmartcity.service;

import com.xmsmartcity.pojo.TpProject;

import java.util.List;

/**
 * @Author: EzerXie
 * @Description:
 * @Date: Created on 11:57 2018/1/22
 * @Modified By:
 */
public interface ProjectService extends BaseService<TpProject> {

    //新增项目
    public String insertProject(TpProject project);
    public TpProject insertProject2(TpProject project);

    //删除项目
    public String delectProject(int pId);

    //修改项目
    public String updateProject(TpProject project);

    //查询/搜索 项目
    public List<TpProject> selectAllProject(int uId);


}
