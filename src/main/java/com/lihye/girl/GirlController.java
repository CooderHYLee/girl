package com.lihye.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

//和Controller的区别：Controller必须是以配合Template的方式；
//@Controller
@RestController
public class GirlController {

    //
//    @Value("${girl.content}")
//    private String content;

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        return  "hello"+girlProperties.getContent();
    }

    @RequestMapping(value = "/hi/{msg}",method = RequestMethod.GET)
    public String hi(@PathVariable("msg") String msg){
        return  "hello "+msg;
    }

    // 获取   ？msg=xxx&id=1  之类的数据
    @RequestMapping(value = "/hey",method = RequestMethod.GET)
    public String hey(@RequestParam("msg") String msg, @RequestParam(value = "id",required = true,defaultValue = "1") Integer id){
        return  "hello "+msg+";id "+id;
    }

    // @RequestMapping(value = "/hey",method = RequestMethod.GET)  ====  getMapping("xxx")
}
