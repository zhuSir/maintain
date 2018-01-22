package com.xmsmartcity.service;

import com.xmsmartcity.mapper.TsMaintainMapper;
import com.xmsmartcity.pojo.TsMaintain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Owner on 2018/1/22 0022.
 */
@Service
public interface MaintainService extends BaseService<TsMaintain>{

    public List<TsMaintain> selectList();

}
