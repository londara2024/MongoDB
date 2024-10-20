package com.microservice.learn.service;

import java.util.List;

import com.microservice.learn.dto.AuthorDTO;
import com.microservice.learn.entity.Author;
import com.microservice.learn.utils.ApiBaseResponse;

public interface AuthorService {
	ApiBaseResponse<Author> createAuthor(AuthorDTO authorDTO);
	ApiBaseResponse<List<Author>> getAllAuthor();
	ApiBaseResponse<Author> getAuthorById(String Id);
	ApiBaseResponse<Author> deleteAuthor(String Id);
	ApiBaseResponse<Author> updateAuthor(String Id, AuthorDTO authorDTO);
}
