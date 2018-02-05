package com.xmsmartcity.service;

import com.xmsmartcity.pojo.TsFunctionAuthority;

import java.util.List;

/**
 * Created by welleast on 2018/2/5.
 */
public interface GroupAuthority extends BaseService<TsFunctionAuthority> {

    Integer insert(TsFunctionAuthority record);


    List<TsFunctionAuthority> selectWithGroupListIDKey(Integer id);


}
