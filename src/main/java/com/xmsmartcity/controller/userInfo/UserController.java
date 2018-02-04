package com.xmsmartcity.controller.userInfo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xmsmartcity.pojo.CommonObjParam;
import com.xmsmartcity.pojo.CommonObjReturn;
import com.xmsmartcity.pojo.TeEquip;
import com.xmsmartcity.pojo.TsUser;
import com.xmsmartcity.service.UserService;
import com.xmsmartcity.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户操作
 * Created by zzf on 2018/1/19 0019.
 */
@RestController
@RequestMapping(value = "/userinfo")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 注册接口
     *
     * @return
     */
    public CommonObjReturn register(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response) {
        TsUser tsUser = JSON.parseObject(JSON.toJSONString(objparam.getData()), TsUser.class);
        String result = userService.addUser(tsUser);
        CommonObjReturn commonObjReturn = new CommonObjReturn();
        commonObjReturn.setData(result);
        commonObjReturn.setResult("true");
        commonObjReturn.setResultTime(DateUtils.DateToString(new Date(), DateUtils.formatStr_yyyyMMddHHmmss));
        return commonObjReturn;
    }

    /**
     * 登陆接口
     *
     * @return
     */
    public CommonObjReturn login(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response) {
        TsUser tsUser = JSON.parseObject(JSON.toJSONString(objparam.getData()), TsUser.class);
        String result = userService.selectUser(tsUser);
        CommonObjReturn commonObjReturn = new CommonObjReturn();
        commonObjReturn.setData(result);
        commonObjReturn.setResult("true");
        commonObjReturn.setResultTime(DateUtils.DateToString(new Date(), DateUtils.formatStr_yyyyMMddHHmmss));
        return commonObjReturn;
    }

    /**
     * id获取用户接口
     *
     * @return
     */
    @RequestMapping(value = "/getUserById", method = RequestMethod.POST)
    private TsUser getUserById(String userId) {
        Integer id = Integer.valueOf(userId);
        TsUser result = userService.selectUserById(id);
        return result;
    }

    @GetMapping("/list")
    public List selectList(String phone, String name) {
        List<Map<String, Object>> res = userService.selectList(phone, name);
        return res;
    }

    /**
     * 用户手机查询名称接口
     *
     * @return
     */
    @RequestMapping(value = "/byphone")
    public TsUser selectById(String phone) {
        TsUser result = userService.selectByPhone(phone);
        return result;
    }

    /**
     * id获取移除公司
     *
     * @return
     */
    public CommonObjReturn deleteGroupUser(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response) {
        HashMap map = (HashMap) objparam.getData();
        Integer id = Integer.valueOf(map.get("id").toString());
        JSONObject result = userService.deleteGroupUser(id);
        CommonObjReturn commonObjReturn = new CommonObjReturn();
        commonObjReturn.setData(result);
        commonObjReturn.setResult("true");
        commonObjReturn.setResultTime(DateUtils.DateToString(new Date(), DateUtils.formatStr_yyyyMMddHHmmss));
        return commonObjReturn;
    }


}
