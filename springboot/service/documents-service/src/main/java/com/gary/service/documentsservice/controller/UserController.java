package com.gary.service.documentsservice.controller;

import com.gary.service.documentsservice.service.MongoServiceGrpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private MongoServiceGrpc mongoServiceGrpc;

    @GetMapping("allUser")
    public String getAllUsers() {
        return mongoServiceGrpc.getAllUser();
    }

    @GetMapping("insertRandom")
    public void insertRandomUser() {
        mongoServiceGrpc.insertRandomUser();
    }

    @GetMapping("findByName")
    public String findByName(String name) {
        return mongoServiceGrpc.findByName(name);
    }
}
