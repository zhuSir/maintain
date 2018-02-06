package com.xmsmartcity.service;

import com.xmsmartcity.pojo.TsAuthorityList;
import java.util.List;

/**
 * Created by welleast on 2018/2/5.
 */
public interface AuthorityListService extends BaseService<TsAuthorityList>{

        //获取权限列表的值
        public List<TsAuthorityList> getAuList();

}
