package com.letian.consume.controller;


import com.letian.consume.service.HelloService;
import com.letian.consume.service.api.UserSOA;
import com.letian.consume.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class HelloController {

    @Autowired
    HelloService helloService;

    @Autowired
    private UserSOA userSOA;


    @GetMapping("test")
    public String test(){
        return  "test";
    }

    @GetMapping("/hi")
    public String hi(@RequestParam String name){
        return helloService.hiService( name ) + "（rest+ribbon）(Finchley版本)";
    }

    @GetMapping("/getUser")
    public String getUser(String name){
        return userSOA.getUser(name).toString()  + "";
    }
}
