package com.xmsmartcity.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xmsmartcity.mapper.BaseDao;
import com.xmsmartcity.mapper.TsFunctionGroupMapper;
import com.xmsmartcity.mapper.TsUserMapper;
import com.xmsmartcity.pojo.TsUser;
import com.xmsmartcity.pojo.TsFunctionGroup;

import com.xmsmartcity.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by welleast on 2018/1/23.
 */

@Service("UserGroupService")
public class UserGrouplmpl extends BaseServiceImpl<TsFunctionGroup> implements UserGroupService {

    public UserGrouplmpl(BaseDao<TsFunctionGroup> dao) {
        super(dao);
    }


    @Autowired
    private TsFunctionGroupMapper dao;

    @Autowired
    private TsUserMapper userdao;

    //创建公司
    @Override
    public String creatGroup(String companyName, String reatUserName, int reatUserID) {
        TsFunctionGroup group = new TsFunctionGroup();
        group.setGroupName(companyName);
        group.setPid("0");
        group.setCreateName(reatUserName);//创建人
        group.setCreateBy(reatUserID);// 创建人
        JSONObject json = new JSONObject();
        int result = dao.insert(group);
        if (result == 1) {
            //创建成功

            int updateUserINfo = userdao.updateUserCompanyInfo(reatUserID, group.getId(), companyName);
            if (updateUserINfo == 1) {
                json.put("code", 0);
                json.put("info", "创建成功");
                json.put("companyID", group.getId());
                json.put("companyName", companyName);

            } else {
                json.put("code", 1);
                json.put("info", "创建失败");
            }

            //修改创建人的个人信息增加

            json.put("code", 0);
            json.put("info", "创建成功");

        } else {
            //创建失败
            json.put("code", 1);
            json.put("info", "创建失败");

        }

        return json.toString();
    }


    //创建组
    @Override
    public String insertGroup(String groupname, String companyID, String reatUserName, int reatUserID) {
        TsFunctionGroup group = new TsFunctionGroup();
        group.setGroupName(groupname);
        group.setPid(companyID);
        group.setCreateName(reatUserName);//创建人
        group.setCreateBy(reatUserID);// 创建人
        int result = dao.insert(group);
        return result + "";
    }

    @Override
    public List<TsFunctionGroup> getGroupList(String id) {
        List<TsFunctionGroup> result = dao.getGroupList(id);
        return result;
    }

    @Override
    public TsFunctionGroup getGroup(String companyID, String groupname) {
       TsFunctionGroup result = dao.getGroup(companyID,groupname);
        return result;
    }

    @Override
    public JSONObject removeGroup(String groupId) {
        Integer id = Integer.valueOf(groupId);
        JSONObject json = new JSONObject();
        int deleteState = dao.deleteByPrimaryKey(id);
        if (deleteState==0){
            json.put("code", 1);
            json.put("info", "移除失败");
        }else {
            json.put("code", 0);
            json.put("info", "移除成功");
        }
        return json;
    }

    @Override
    public TsFunctionGroup getcompanyInfo(int ID) {
        TsFunctionGroup grou = dao.selectByPrimaryKey(ID);
        return grou;
    }


    @Override
    public String companyInviteMenber(String phone, String companyID) {

        JSONObject json = new JSONObject();
        if (null == phone || "".equals(phone)) {//参数不存在
            json.put("code", 1);
            json.put("info", "却少参数");
        } else {//参数存在，判断是否重复创建
            TsUser userReturn = userdao.selectUser(phone);
            if (userReturn.getCompanyid() == 0) {
                //获取人的ID，修改她的公司ID，
                json.put("code", 0);
                json.put("info", "success");
            } else {
                //用户有公司
                json.put("code", 0);
                json.put("info", "用户有公司");
            }
        }
        return json.toString();
    }


}
