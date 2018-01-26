package com.xmsmartcity.service;

import com.xmsmartcity.pojo.TsFunctionGroup;
import java.util.List;

/**
 * Created by welleast on 2018/1/23.
 */
public interface UserGroupService extends BaseService<TsFunctionGroup> {


    //创建公司
    public Object creatGroup(String companyName,String reatUserName,String reatUserID);

    //创建组
    public String insertGroup(String groupname ,String companyID,String reatUserName,String reatUserID);

    int insertBackID(TsFunctionGroup record);

    //获组列表
    public List<TsFunctionGroup> getGroupList(String sonID);

    //过去公司的详情，根据id获取，

    public TsFunctionGroup getcompanyInfo(String ID);

    //邀请成员
    public String  companyInviteMenber(String phone,String companyID);

}