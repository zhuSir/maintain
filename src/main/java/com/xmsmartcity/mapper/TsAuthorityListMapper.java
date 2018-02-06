package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsAuthorityList;

import java.util.List;

public interface TsAuthorityListMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TsAuthorityList record);

    int insertSelective(TsAuthorityList record);

    TsAuthorityList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TsAuthorityList record);

    int updateByPrimaryKey(TsAuthorityList record);

    public List<TsAuthorityList> getAuList();

    //设置组的权限
    int settingGroupAu(Integer groupId,Integer auId);
        //查询组ID，和auID相同的记录
    TsAuthorityList seleteWithGroupIdAu(Integer groupId,Integer auId);


    //删除关联组的权限
    int deleteGroupWithID(Integer id);
    //插入关联组的权限
    int insertGroupWithID(Integer groupId,Integer auId);

}