package com.gary.service.documentsservice.service;

import com.gary.library.grpc.interfaces.mongo.repo.*;
import com.google.protobuf.Empty;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MongoServiceGrpc {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GrpcClient("mongo-document-repository")
    private MongoRepoServiceGrpc.MongoRepoServiceBlockingStub serviceBlockingStub;

    public String sayHello(String name) {
        StringRequest stringRequest = StringRequest.newBuilder().setValue(name).build();
        StringResponse stringResponse1 = serviceBlockingStub.hello(stringRequest);
        return stringResponse1.getValue();
    }

    public void insertRandomUser() {
        serviceBlockingStub.insertRandomUser(Empty.newBuilder().build());
    }

    public String findByName(String name) {
        name = Optional.ofNullable(name).orElse("EmptyName");
        UserResponse userResponse = serviceBlockingStub.findByName(NameRequest.newBuilder().setName(name).build());
        User user = userResponse.getUser();
        logger.debug("find by name = {}, result = {}", name, user);
        System.out.println(String.format("find by name = %s, result = %s", name, user));
        return String.format("find by name = %s, result = %s", name, user);
    }

    public String getAllUser(){
        UserListResponse userListResponse = serviceBlockingStub.getAllUsers(Empty.newBuilder().build());
        List<User> userList = userListResponse.getUserList();
        logger.debug("get user list with size = {}", userList.size());
        return String.format("get user list with size = %s", userList.size());

    }

}
