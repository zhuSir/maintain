package com.xmsmartcity.controller.equip;

import com.alibaba.fastjson.JSON;
import com.xmsmartcity.pojo.CommonObjParam;
import com.xmsmartcity.pojo.CommonObjReturn;
import com.xmsmartcity.pojo.TeEquipType;
import com.xmsmartcity.service.EquipTypeService;
import com.xmsmartcity.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 *
 */
@Controller
public class EquipTypeController {

    @Autowired
    EquipTypeService equipTypeService;

    @ResponseBody
    public CommonObjReturn listEquipType(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response){
        List<TeEquipType> list=equipTypeService.selectEquipTypeList();
        CommonObjReturn commonObjReturn=new CommonObjReturn();
        commonObjReturn.setData(list);
        commonObjReturn.setResult("true");
        commonObjReturn.setResultTime(DateUtils.DateToString(new Date(),DateUtils.formatStr_yyyyMMddHHmmss));
        return commonObjReturn;
    }

    @ResponseBody
    public CommonObjReturn saveEquipType(@RequestBody CommonObjParam objparam, HttpServletRequest request, HttpServletResponse response){
        TeEquipType equipType= JSON.parseObject(objparam.getData().toString(),TeEquipType.class);
        equipTypeService.insertSelective(equipType);
        CommonObjReturn commonObjReturn=new CommonObjReturn();
        commonObjReturn.setResult("true");
        commonObjReturn.setResultTime(DateUtils.DateToString(new Date(),DateUtils.formatStr_yyyyMMddHHmmss));
        return commonObjReturn;
    }
}
