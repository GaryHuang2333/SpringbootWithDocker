package com.gary.service.mongodocumentrepository.service;

import com.gary.library.grpc.interfaces.mongo.repo.*;
import com.gary.service.mongodocumentrepository.entities.User;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public void insertRandomUser(Empty request, StreamObserver<Empty> responseObserver) {
        userService.insertRandomUser();
        responseObserver.onNext(request);
        responseObserver.onCompleted();
    }

    @Override
    public void findByName(NameRequest request, StreamObserver<UserResponse> responseObserver) {
        User user = userService.findByName(request.getName());
        responseObserver.onNext(UserResponse.newBuilder().setUser(toGrpcUser(user)).build());
        responseObserver.onCompleted();
    }

    private com.gary.library.grpc.interfaces.mongo.repo.User toGrpcUser(User user) {
        com.gary.library.grpc.interfaces.mongo.repo.User.Builder builder = com.gary.library.grpc.interfaces.mongo.repo.User.newBuilder();

        builder.setId(user.getId());
        builder.setName(user.getName());
        builder.setAge(user.getAge());
        builder.setGender(user.getGender());
        builder.setHobbies(user.getHobbies());
        builder.setFans(user.getFans());
        builder.setFansNum(user.getFansNum());
        builder.setFollowings(user.getFollowings());
        builder.setFollowingNum(user.getFollowingNum());
        builder.setLike(user.getLike());
        builder.setFavourite(user.getFavourite());
        builder.setBlogsIds(user.getBlogsIds());
        builder.setBlogsNum(user.getBlogsNum());

        com.gary.library.grpc.interfaces.mongo.repo.User build = builder.build();
        return build;
    }

    private List<com.gary.library.grpc.interfaces.mongo.repo.User> toGrpcUserList(List<User> userList) {
        ArrayList<com.gary.library.grpc.interfaces.mongo.repo.User> grpcUserList = new ArrayList<>();

        if (userList == null || userList.size() <= 0) {
            return grpcUserList;
        }

        for (User user : userList) {
            grpcUserList.add(toGrpcUser(user));
        }

        return grpcUserList;
    }
}
