package com.gary.service.documentsservice.service;

import com.gary.library.grpc.interfaces.mongo.repo.*;
import com.gary.library.mongomodel.utils.UserUtil;
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

    public com.gary.library.mongomodel.entities.User insertRandomUser() {
        UserResponse userResponse = serviceBlockingStub.insertRandomUser(Empty.newBuilder().build());
        com.gary.library.mongomodel.entities.User insertedUser = UserUtil.toModelUser(userResponse.getUser());
        return insertedUser;
    }

    public com.gary.library.mongomodel.entities.User findByName(String name) {
        name = Optional.ofNullable(name).orElse("EmptyName");
        UserResponse userResponse = serviceBlockingStub.findByName(NameRequest.newBuilder().setName(name).build());
        com.gary.library.mongomodel.entities.User findUser = UserUtil.toModelUser(userResponse.getUser());
        logger.debug("find by name = {}, result = {}", name, findUser);
        System.out.println(String.format("find by name = %s, result = %s", name, findUser));
        return findUser;
    }

    public List<com.gary.library.mongomodel.entities.User> getAllUser() {
        UserListResponse userListResponse = serviceBlockingStub.getAllUsers(Empty.newBuilder().build());
        List<User> userList = userListResponse.getUserList();
        List<com.gary.library.mongomodel.entities.User> getUserList = UserUtil.toModelUserList(userList);
        logger.debug("get user list = {}", getUserList);
        return getUserList;

    }

}
