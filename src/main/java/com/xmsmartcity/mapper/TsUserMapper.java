package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsUser;
import org.springframework.stereotype.Repository;

@Repository
public interface TsUserMapper extends BaseDao<TsUser>{

    TsUser selectUser(String phone);

}