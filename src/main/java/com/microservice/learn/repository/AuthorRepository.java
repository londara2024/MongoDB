package com.microservice.learn.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.learn.entity.Author;

@Repository
public interface AuthorRepository extends MongoRepository<Author, String>{

}
