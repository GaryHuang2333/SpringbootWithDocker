package com.gary.service.mongodocumentrepository.entities;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Optional;

/**
 * - user
 *      - name : string
 *      - age : int ([0,120])
 *      - gender : string (male/female)
 *      - hobbies : string (list of hobbies, seperated by ",")
 *      - fans : string (list of usernames, seperated by ",")
 *      - fansNum : int
 *      - followings : string (list of usernames, seperated by ",")
 *      - followingsNum : int
 *      - like : string (list of blog id, seperated by ",")
 *      - favourite : string (list of blog id, seperated by ",")
 *      - blogsIds : string (list of posted blog id, repost is included, seperated by ",")
 *      - blogsNum : int
 */

@Document("user")
public class User {
    @Id
    private String id;
    private String name;
    private int age;
    private String gender;
    private String hobbies;
    private String fans;
    private int fansNum;
    private String followings;
    private int followingNum;
    private String like;
    private String favourite;
    private String blogsIds;
    private int blogsNum;

    public void setRandomName() {
        double random = Math.floor(Math.random() * 1000);
        this.name = name + "_" + random;
    }

    public void renewObjectId() {
        ObjectId objectId = new ObjectId();
        this.id = objectId.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Optional.ofNullable(name).orElse("");
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return Optional.ofNullable(gender).orElse("");
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHobbies() {
        return Optional.ofNullable(hobbies).orElse("");
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getFans() {
        return Optional.ofNullable(fans).orElse("");
    }

    public void setFans(String fans) {
        this.fans = fans;
    }

    public int getFansNum() {
        return fansNum;
    }

    public void setFansNum(int fansNum) {
        this.fansNum = fansNum;
    }

    public String getFollowings() {
        return Optional.ofNullable(followings).orElse("");
    }

    public void setFollowings(String followings) {
        this.followings = followings;
    }

    public int getFollowingNum() {
        return followingNum;
    }

    public void setFollowingNum(int followingNum) {
        this.followingNum = followingNum;
    }

    public String getLike() {
        return Optional.ofNullable(like).orElse("");
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getFavourite() {
        return Optional.ofNullable(favourite).orElse("");
    }

    public void setFavourite(String favourite) {
        this.favourite = favourite;
    }

    public String getBlogsIds() {
        return Optional.ofNullable(blogsIds).orElse("");
    }

    public void setBlogsIds(String blogsIds) {
        this.blogsIds = blogsIds;
    }

    public int getBlogsNum() {
        return blogsNum;
    }

    public void setBlogsNum(int blogsNum) {
        this.blogsNum = blogsNum;
    }

    public User() {
    }

    public User(String id, String name, int age, String gender, String hobbies, String fans, int fansNum, String followings, int followingNum, String like, String favourite, String blogsIds, int blogsNum) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.hobbies = hobbies;
        this.fans = fans;
        this.fansNum = fansNum;
        this.followings = followings;
        this.followingNum = followingNum;
        this.like = like;
        this.favourite = favourite;
        this.blogsIds = blogsIds;
        this.blogsNum = blogsNum;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", hobbies='" + hobbies + '\'' +
                ", fans='" + fans + '\'' +
                ", fansNum=" + fansNum +
                ", followings='" + followings + '\'' +
                ", followingNum=" + followingNum +
                ", like='" + like + '\'' +
                ", favourite='" + favourite + '\'' +
                ", blogsIds='" + blogsIds + '\'' +
                ", blogsNum=" + blogsNum +
                '}';
    }
}