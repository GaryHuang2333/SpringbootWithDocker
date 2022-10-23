package com.gary.service.documentsservice.controller;

import com.gary.service.documentsservice.service.MongoServiceGrpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloController {

    @Autowired
    private MongoServiceGrpc mongoServiceGrpc;

    @GetMapping("actuator/info")
    public String info(String name){
        return "hello to " + name + " in " + LocalDateTime.now();
    }

        @GetMapping("hello")
    public String hello(String name){
        return mongoServiceGrpc.sayHello(name);
    }


}
