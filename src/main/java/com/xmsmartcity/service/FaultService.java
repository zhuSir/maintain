package com.xmsmartcity.service;

import com.xmsmartcity.pojo.TsFault;

import java.util.List;
import java.util.Map;

/**
 * Created by zhugw on 2018/1/23 0023.
 */
public interface FaultService extends BaseService<TsFault>{

    List<Map<String,Object>> selectList();

    int saveFaultInfo(TsFault object);
}
