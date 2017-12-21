package com.lihye.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LeafTemplateController {

    @Autowired
    private GirlProperties girlProperties;

    //默认在resource文件下templates下建html文件
    @RequestMapping(value = "/leaf",method = RequestMethod.GET)
    public String say(){
        return "index";
    }
}
