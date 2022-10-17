package com.gary.service.documentsservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloController {

    @GetMapping("actuator/info")
    public String info(String name){
        return "hello to " + name + " in " + LocalDateTime.now();
    }
}
