package com.microservice.learn.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.learn.entity.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String>{}
