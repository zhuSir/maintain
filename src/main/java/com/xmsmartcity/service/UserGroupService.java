package com.xmsmartcity.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.xmsmartcity.pojo.TsFunctionGroup;

/**
 * Created by welleast on 2018/1/23.
 */
public interface UserGroupService extends BaseService<TsFunctionGroup> {


    //创建公司
    public JSONObject creatGroup(String companyName, String reatUserName, Integer reatUserID);

    //创建组
    public String insertGroup(String groupname ,String companyID,String reatUserName,int reatUserID);



    //获组列表
    public List<TsFunctionGroup> getGroupList(String sonID);

    //过去公司的详情，根据id获取，z

    public TsFunctionGroup getcompanyInfo(int ID);

    //邀请成员
    public String  companyInviteMenber(String phone,String companyID);

}
