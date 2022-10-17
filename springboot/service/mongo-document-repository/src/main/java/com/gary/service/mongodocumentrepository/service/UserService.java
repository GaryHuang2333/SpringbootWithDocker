package com.gary.service.mongodocumentrepository.service;

import com.gary.service.mongodocumentrepository.dao.UserRepository;
import com.gary.service.mongodocumentrepository.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        List<User> all = userRepository.findAll();
        return Optional.ofNullable(all).orElse(new ArrayList<>());
    }

    public void insertRandomUser(){
        User user = userRepository.findFirstByName("testUser1");
        user.setRandomName();
        user.renewObjectId();
        User insert = userRepository.insert(user);
    }

    public User findByName(String name){
        User user = userRepository.findFirstByName(name);
        return Optional.ofNullable(user).orElse(new User());
    }

}
