package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TsUserMapper extends BaseDao<TsUser>{

    TsUser selectUser(String phone);

    TsUser selectUserById(int userId);

    List<Map<String,Object>> selectList(@Param("phone")String mobilePhone,@Param("name") String createName);

}