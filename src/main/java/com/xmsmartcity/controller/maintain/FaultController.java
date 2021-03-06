package com.xmsmartcity.controller.maintain;

import com.xmsmartcity.pojo.TsFault;
import com.xmsmartcity.service.FaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 2018/1/22 0022.
 */
@Controller
@RequestMapping("/fault")
public class FaultController {

    @Autowired
    private FaultService service;

    @RequestMapping(value = "/add")
    @ResponseBody
    public int addFault(TsFault object){
        int res = service.saveFaultInfo(object);
        return res;
    }

    @ResponseBody
    @RequestMapping(value = "/list")
    public List<Map<String,Object>> faultList(String id){
        System.out.println(id);
        List<Map<String,Object>> results = service.selectList();
        return results;
    }

}
