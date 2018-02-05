package com.xmsmartcity.service;

import com.xmsmartcity.pojo.TsFunctionAuthority;

/**
 * Created by welleast on 2018/2/5.
 */
public interface GroupAuthority extends BaseService<TsFunctionAuthority> {

    TsFunctionAuthority selectWithConpanyIDKey(Integer id);


}
