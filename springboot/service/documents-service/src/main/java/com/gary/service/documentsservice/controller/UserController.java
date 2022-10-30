package com.gary.service.documentsservice.controller;

import com.gary.library.mongomodel.entities.User;
import com.gary.service.documentsservice.service.MongoServiceGrpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private MongoServiceGrpc mongoServiceGrpc;

    @GetMapping("allUser")
    public String getAllUsers() {
        List<User> allUser = mongoServiceGrpc.getAllUser();

        return "All users : " + allUser.toString();
    }

    @GetMapping("insertRandom")
    public String insertRandomUser() {
        User user = mongoServiceGrpc.insertRandomUser();
        return "Inserted random user : " + user;
    }

    @GetMapping("findByName")
    public String findByName(String name) {
        User user = mongoServiceGrpc.findByName(name);
        return "find user : " + user;

    }
}
