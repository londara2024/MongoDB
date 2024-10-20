package com.microservice.learn.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.learn.entity.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String>{
}
