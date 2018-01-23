package com.xmsmartcity.controller.maintain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Owner on 2018/1/22 0022.
 */
@RestController
public class FaultController {

    @RequestMapping(value = "/add")
    public int addFault(){
        return 1;
    }

}
