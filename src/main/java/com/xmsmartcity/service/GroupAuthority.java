package com.xmsmartcity.service;

import com.xmsmartcity.pojo.TsAuthorityList;
import com.xmsmartcity.pojo.TsFunctionAuthority;

import java.util.List;

/**
 * Created by welleast on 2018/2/5.
 */
public interface GroupAuthority extends BaseService<TsFunctionAuthority> {

    Integer insert(TsFunctionAuthority record);


    List<TsFunctionAuthority> selectWithGroupListIDKey(Integer id);

    //设置组的权限
    int settingGroupAu(Integer groupId,Integer auId);
    //查询组ID，和auID相同的记录
    TsAuthorityList seleteWithGroupIdAu(Integer groupId, Integer auId);



    //删除关联组的权限
    int deleteGroupWithID(Integer id);
    //插入关联组的权限
    int insertGroupWithID(TsFunctionAuthority record);

}
