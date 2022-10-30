package com.gary.service.mongodocumentrepository.dao;

import com.gary.library.mongomodel.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findFirstByName(String name);
}
