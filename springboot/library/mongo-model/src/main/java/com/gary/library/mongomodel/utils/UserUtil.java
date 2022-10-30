package com.gary.library.mongomodel.utils;

import com.gary.library.mongomodel.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserUtil {
    public static com.gary.library.grpc.interfaces.mongo.repo.User toGrpcUser(User modelUser) {
        com.gary.library.grpc.interfaces.mongo.repo.User.Builder grpcUser = com.gary.library.grpc.interfaces.mongo.repo.User.newBuilder();

        grpcUser.setId(modelUser.getId());
        grpcUser.setName(modelUser.getName());
        grpcUser.setAge(modelUser.getAge());
        grpcUser.setGender(modelUser.getGender());
        grpcUser.setHobbies(modelUser.getHobbies());
        grpcUser.setFans(modelUser.getFans());
        grpcUser.setFansNum(modelUser.getFansNum());
        grpcUser.setFollowings(modelUser.getFollowings());
        grpcUser.setFollowingNum(modelUser.getFollowingNum());
        grpcUser.setLike(modelUser.getLike());
        grpcUser.setFavourite(modelUser.getFavourite());
        grpcUser.setBlogsIds(modelUser.getBlogsIds());
        grpcUser.setBlogsNum(modelUser.getBlogsNum());

        com.gary.library.grpc.interfaces.mongo.repo.User build = grpcUser.build();
        return build;
    }

    public static List<com.gary.library.grpc.interfaces.mongo.repo.User> toGrpcUserList(List<User> modelUserList) {
        ArrayList<com.gary.library.grpc.interfaces.mongo.repo.User> grpcUserList = new ArrayList<>();

        if (modelUserList == null || modelUserList.size() <= 0) {
            return grpcUserList;
        }

        for (User modelUser : modelUserList) {
            grpcUserList.add(toGrpcUser(modelUser));
        }

        return grpcUserList;
    }

    public static User toModelUser(com.gary.library.grpc.interfaces.mongo.repo.User grpcUser) {
        User modelUser = new User();
        modelUser.setId(grpcUser.getId());
        modelUser.setName(grpcUser.getName());
        modelUser.setAge(grpcUser.getAge());
        modelUser.setGender(grpcUser.getGender());
        modelUser.setHobbies(grpcUser.getHobbies());
        modelUser.setFans(grpcUser.getFans());
        modelUser.setFansNum(grpcUser.getFansNum());
        modelUser.setFollowings(grpcUser.getFollowings());
        modelUser.setFollowingNum(grpcUser.getFollowingNum());
        modelUser.setLike(grpcUser.getLike());
        modelUser.setFavourite(grpcUser.getFavourite());
        modelUser.setBlogsIds(grpcUser.getBlogsIds());
        modelUser.setBlogsNum(grpcUser.getBlogsNum());

        return modelUser;
    }

    public static List<User> toModelUserList(List<com.gary.library.grpc.interfaces.mongo.repo.User> grpcUserList) {
        ArrayList<User> modelUserList = new ArrayList<>();

        if (grpcUserList == null || grpcUserList.size() <= 0) {
            return modelUserList;
        }

        for (com.gary.library.grpc.interfaces.mongo.repo.User grpcUser : grpcUserList) {
            modelUserList.add(toModelUser(grpcUser));
        }

        return modelUserList;
    }
}
