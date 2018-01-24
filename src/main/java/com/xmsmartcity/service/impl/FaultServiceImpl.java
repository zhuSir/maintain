package com.xmsmartcity.service.impl;

import com.xmsmartcity.mapper.BaseDao;
import com.xmsmartcity.mapper.TsFaultMapper;
import com.xmsmartcity.pojo.TsFault;
import com.xmsmartcity.service.FaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by zhugw on 2018/1/23 0023.
 */
@Service("faultService")
public class FaultServiceImpl extends BaseServiceImpl<TsFault> implements FaultService{

    public FaultServiceImpl(BaseDao<TsFault> dao) {
        super(dao);
    }

    @Autowired
    private TsFaultMapper dao;

    @Override
    public List<Map<String,Object>> selectList() {
        List<Map<String,Object>> result = dao.selectList();
//        List<List<Object>> res = new ArrayList<List<Object>>();
//        for(Map obj : result){
//            List<Object> resObj = new ArrayList<Object>();
//            resObj.add(obj.get("fault_code"));
//            resObj.add(obj.get("company_id"));
//            resObj.add(obj.get("project_id"));
//            resObj.add(obj.get("createtime"));
//            resObj.add(obj.get("remark_reason"));
//            resObj.add(obj.get("fault_type"));
//            resObj.add(obj.get("fault_user_id"));
//            resObj.add(obj.get("equip_id"));
//            res.add(resObj);
//        }
        return result;
    }

    @Override
    public int saveFaultInfo(TsFault object) {
        object.setCreatetime(new Date());
        int res = dao.insertSelective(object);
        return res;
    }
}
