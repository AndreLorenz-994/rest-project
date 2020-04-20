package com.myblog.rest.repository;

import com.myblog.rest.model.AuthorityName;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myblog.rest.model.Authority;

public interface AuthorityRepository extends MongoRepository<Authority, Long> {
    Authority findByName(AuthorityName name);

}
