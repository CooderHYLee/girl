package com.lihye.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JSPTestController {

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/jsp")
    public String jsp(){
        return "test";
    }
}
