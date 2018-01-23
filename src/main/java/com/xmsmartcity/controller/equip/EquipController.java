package com.xmsmartcity.controller.equip;

import com.xmsmartcity.pojo.CommonObjParam;
import com.xmsmartcity.pojo.CommonObjReturn;
import com.xmsmartcity.pojo.TeEquip;
import com.xmsmartcity.service.EquipService;
import com.xmsmartcity.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
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
        //这是注释
        List<TeEquip> list=equipService.selectEquipList();
        System.out.print("ddddddd");
        CommonObjReturn commonObjReturn=new CommonObjReturn();
        commonObjReturn.setData(list);
        commonObjReturn.setResult("true");
        commonObjReturn.setResultTime(DateUtils.DateToString(new Date(),DateUtils.formatStr_yyyyMMddHHmmss));
        return commonObjReturn;
    }

}
