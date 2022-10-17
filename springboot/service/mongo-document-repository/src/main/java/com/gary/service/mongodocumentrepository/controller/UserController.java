package com.gary.service.mongodocumentrepository.controller;

import com.gary.service.mongodocumentrepository.entities.User;
import com.gary.service.mongodocumentrepository.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("getAllUsers")
    public String getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        return allUsers.toString();
    }
}
