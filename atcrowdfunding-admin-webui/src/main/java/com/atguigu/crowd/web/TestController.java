package com.atguigu.crowd.web;

import com.atguigu.crowd.bean.Admin;
import com.atguigu.crowd.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("index")
    public Admin getIndex(){
      return testService.getAdmin(1);
    }

}
