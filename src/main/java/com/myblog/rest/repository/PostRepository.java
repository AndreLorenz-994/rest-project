package com.myblog.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myblog.rest.model.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}