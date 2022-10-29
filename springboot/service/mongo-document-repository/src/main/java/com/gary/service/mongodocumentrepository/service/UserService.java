package com.gary.service.mongodocumentrepository.service;

import com.gary.service.mongodocumentrepository.dao.UserRepository;
import com.gary.service.mongodocumentrepository.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> all = userRepository.findAll();
        List<User> userList = Optional.ofNullable(all).orElse(new ArrayList<>());
        logger.debug("get user list with size = {}", userList.size());
        return userList;
    }

    public void insertRandomUser() {
        User user = userRepository.findFirstByName("testUser1");
        user.setRandomName();
        user.renewObjectId();
        User insert = userRepository.insert(user);
        logger.debug("insert user = {}", user);
    }

    public User findByName(String name) {
        name = Optional.ofNullable(name).orElse("EmptyName");
        User user = userRepository.findFirstByName(name);
        user = Optional.ofNullable(user).orElse(new User());
        logger.debug("find by name = {}, result = {}", name, user);
        return user;
    }

}
