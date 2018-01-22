package com.xmsmartcity.controller.maintain;

import com.xmsmartcity.service.MaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhugw on 2018/1/22 0022.
 */
@RestController
@RequestMapping(value = "/maintain")
public class MaintainController {

    @Autowired
    private MaintainService service;

    @RequestMapping(value = "/list")
    public String maintainList(){
        service.selectList();

        return null;
    }
}
