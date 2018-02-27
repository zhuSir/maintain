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
import java.util.*;

/**
 *
 */
@Controller
public class EquipController {

    @Autowired
    EquipService equipService;

    @ResponseBody
    public CommonObjReturn listEquip(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response){

        List<TeEquip> list=equipService.selectEquipList();
        CommonObjReturn commonObjReturn=new CommonObjReturn();
        commonObjReturn.setData(list);
        commonObjReturn.setResult("true");
        commonObjReturn.setResultTime(DateUtils.DateToString(new Date(),DateUtils.formatStr_yyyyMMddHHmmss));
        return commonObjReturn;

    }

    @ResponseBody
    public CommonObjReturn saveEquip(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response){
        TeEquip equip= JSON.parseObject(JSON.toJSONString(objparam.getData()),TeEquip.class);
        Date now=new Date();
        equip.setCreatUserId(1);
        equip.setUpdateUserId(1);
        equip.setCreatetime(now);
        equip.setUpdatetime(now);
        equip.setEquipCode("11111");
        equipService.insertSelective(equip);
        CommonObjReturn commonObjReturn=new CommonObjReturn();
        commonObjReturn.setResult("true");
        commonObjReturn.setData(equip);
        commonObjReturn.setResultTime(DateUtils.DateToString(new Date(),DateUtils.formatStr_yyyyMMddHHmmss));
        return commonObjReturn;
    }

    @ResponseBody
    public CommonObjReturn getEquipById(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response){
        TeEquip equip=equipService.selectByPrimaryKey((int)objparam.getData());
        CommonObjReturn commonObjReturn=new CommonObjReturn();
        commonObjReturn.setData(equip);
        commonObjReturn.setResult("true");
        commonObjReturn.setResultTime(DateUtils.DateToString(new Date(),DateUtils.formatStr_yyyyMMddHHmmss));
        return commonObjReturn;
    }

    @ResponseBody
    public CommonObjReturn deleteEquip(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response){
        equipService.deleteByPrimaryKey((int)objparam.getData());
        CommonObjReturn commonObjReturn=new CommonObjReturn();
        commonObjReturn.setResult("true");
        commonObjReturn.setResultTime(DateUtils.DateToString(new Date(),DateUtils.formatStr_yyyyMMddHHmmss));
        return commonObjReturn;
    }

    @ResponseBody
    public CommonObjReturn updateEquip(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response){
        TeEquip equip= JSON.parseObject(JSON.toJSONString(objparam.getData()),TeEquip.class);
        Date now=new Date();
        equip.setUpdateUserId(1);
        equip.setUpdatetime(now);
        equipService.updateByPrimaryKeySelective(equip);
        CommonObjReturn commonObjReturn=new CommonObjReturn();
        commonObjReturn.setResult("true");
        commonObjReturn.setData(equip);
        commonObjReturn.setResultTime(DateUtils.DateToString(new Date(),DateUtils.formatStr_yyyyMMddHHmmss));
        return commonObjReturn;
    }
}
