package com.xmsmartcity.controller.equip;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xmsmartcity.pojo.CommonObjParam;
import com.xmsmartcity.pojo.CommonObjReturn;
import com.xmsmartcity.pojo.TeEquip;
import com.xmsmartcity.pojo.TsUser;
import com.xmsmartcity.service.EquipService;
import com.xmsmartcity.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

/**
 *
 */
@Controller
public class EquipController {

    @Autowired
    EquipService equipService;

    @ResponseBody
    public CommonObjReturn getEquipList(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response){
        List<TeEquip> list=equipService.selectEquipList();
        CommonObjReturn commonObjReturn=new CommonObjReturn();
        commonObjReturn.setData(list);
        commonObjReturn.setResult("true");
        commonObjReturn.setResultTime(DateUtils.DateToString(new Date(),DateUtils.formatStr_yyyyMMddHHmmss));
        return commonObjReturn;
    }

    @ResponseBody
    public CommonObjReturn addEquip(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response){
        TeEquip equip= JSON.parseObject(objparam.getData().toString(),TeEquip.class);
        equipService.insertSelective(equip);
        CommonObjReturn commonObjReturn=new CommonObjReturn();
        commonObjReturn.setResult("true");
        commonObjReturn.setResultTime(DateUtils.DateToString(new Date(),DateUtils.formatStr_yyyyMMddHHmmss));
        return commonObjReturn;
    }
}
