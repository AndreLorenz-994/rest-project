package com.myblog.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myblog.rest.model.User;

public interface UserRepository extends MongoRepository<User, String>{
	User findByUsername(String username);
}
