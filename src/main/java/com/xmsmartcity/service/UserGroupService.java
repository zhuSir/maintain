package com.xmsmartcity.service;

import com.xmsmartcity.pojo.TpProject;
import com.xmsmartcity.pojo.TsFunctionGroup;

import java.util.List;
import java.util.Map;

/**
 * Created by welleast on 2018/1/23.
 */
public interface UserGroupService extends BaseService<TsFunctionGroup> {

    //创建公司以及组
    public String insertGroup(String groupname);



    //获组列表
    public List<TsFunctionGroup> getGroupList(String sonID);

    //过去公司的详情，根据id获取，

    public TsFunctionGroup getcompanyInfo(String ID);

    //邀请成员
    public String  companyInviteMenber(String phone,String companyID);

}
