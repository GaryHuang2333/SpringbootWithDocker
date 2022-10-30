package com.gary.service.mongodocumentrepository.service;

import com.gary.library.grpc.interfaces.mongo.repo.*;
import com.gary.library.mongomodel.entities.User;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static com.gary.library.mongomodel.utils.UserUtil.toGrpcUser;
import static com.gary.library.mongomodel.utils.UserUtil.toGrpcUserList;

@GrpcService
public class MongoRepoServiceGrpc extends com.gary.library.grpc.interfaces.mongo.repo.MongoRepoServiceGrpc.MongoRepoServiceImplBase {
    @Autowired
    private UserService userService;

    @Override
    public void hello(StringRequest request, StreamObserver<StringResponse> responseObserver) {
        String response = "Hello to " + Optional.ofNullable(request.getValue()).orElse("EmptyName") + " from " + this.getClass().getSimpleName();
        StringResponse stringResponse = StringResponse.newBuilder().setValue(response).build();
        responseObserver.onNext(stringResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllUsers(Empty request, StreamObserver<UserListResponse> responseObserver) {
        List<User> allUsers = userService.getAllUsers();
        UserListResponse userListResponse = UserListResponse.newBuilder().addAllUser(toGrpcUserList(allUsers)).build();
        responseObserver.onNext(userListResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void insertRandomUser(Empty request, StreamObserver<UserResponse> responseObserver) {
        User user = userService.insertRandomUser();
        UserResponse userResponse = UserResponse.newBuilder().setUser(toGrpcUser(user)).build();
        responseObserver.onNext(userResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void findByName(NameRequest request, StreamObserver<UserResponse> responseObserver) {
        User user = userService.findByName(request.getName());
        responseObserver.onNext(UserResponse.newBuilder().setUser(toGrpcUser(user)).build());
        responseObserver.onCompleted();
    }

}
