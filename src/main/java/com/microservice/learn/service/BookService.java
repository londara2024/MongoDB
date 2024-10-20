package com.microservice.learn.service;

import java.util.List;

import com.microservice.learn.dto.BookDTO;
import com.microservice.learn.entity.Book;
import com.microservice.learn.utils.ApiBaseResponse;

public interface BookService {
	ApiBaseResponse<Book> postBook (BookDTO bookDTO);
	ApiBaseResponse<List<Book>> getAllBook ();
	ApiBaseResponse<Book> getById (String Id);
	ApiBaseResponse<Book> deleteBookById (String Id);
}
