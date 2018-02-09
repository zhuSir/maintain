package com.xmsmartcity.service.impl;

import com.xmsmartcity.mapper.BaseDao;
import com.xmsmartcity.mapper.TsFaultMapper;
import com.xmsmartcity.mapper.TsMaintainMapper;
import com.xmsmartcity.mapper.TsUserMapper;
import com.xmsmartcity.pojo.TsFault;
import com.xmsmartcity.pojo.TsMaintain;
import com.xmsmartcity.pojo.TsUser;
import com.xmsmartcity.service.FaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    private TsUserMapper userDao;

    @Autowired
    private TsMaintainMapper maintainDao;

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
        TsUser user = userDao.selectUserById(object.getFaultUserId());
        if(user != null){
            object.setCompanyId(user.getCompanyid());
        }
        object.setCreatetime(new Date());
        int faultId = dao.insertSelective(object);
        //删除维修单
        TsMaintain maintain = new TsMaintain();
        maintain.setCompanyId(object.getCompanyId());
        maintain.setEquipId(object.getEquipId());
        maintain.setFaultId(faultId);
        maintain.setFaultUserId(object.getFaultUserId());
        maintain.setMaintainType(object.getFaultType());
        maintain.setRemarkReason(object.getRemarkReason());
        maintainDao.insertSelective(maintain);
        return 1;
    }

}
