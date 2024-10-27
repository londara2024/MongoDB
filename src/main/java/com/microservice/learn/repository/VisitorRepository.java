package com.microservice.learn.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservice.learn.entity.Visitor;

public interface VisitorRepository extends MongoRepository<Visitor, String>{}
