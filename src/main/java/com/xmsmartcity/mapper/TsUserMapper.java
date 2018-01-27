package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TsUserMapper extends BaseDao<TsUser> {
    TsUser selectUser(String phone);

    TsUser selectUserById(int userId);

    List<Map<String,Object>> selectList(@Param("phone")String mobilePhone, @Param("name") String createName);

    List<TsUser> selectUserList(@Param("companyID")int companyId);

    //邀请用户到组
    int invitePeopleGroup(@Param("phone")String phone,@Param("groupID")String groupID,@Param("companyID")String companyID);

    //更新用户的公司ID
    int updateUserCompanyInfo(@Param("userId")int userId,@Param("companyID")int companyID,@Param("companyName")String companyName);

    //
    int deleteGroupUser(int userId);
}