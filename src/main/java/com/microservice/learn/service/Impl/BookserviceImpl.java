package com.microservice.learn.service.Impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.microservice.learn.dto.BookDTO;
import com.microservice.learn.entity.Book;
import com.microservice.learn.repository.BookRepository;
import com.microservice.learn.service.BookService;
import com.microservice.learn.utils.ApiBaseResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class BookserviceImpl implements BookService{
	
	private final BookRepository bookRepository;

	@Override
	public ApiBaseResponse<Book> postBook(BookDTO bookDTO) {
		// TODO Auto-generated method stub
		ApiBaseResponse<Book> response = new ApiBaseResponse<>();
		
		Book book = new Book(bookDTO);
		book = bookRepository.save(book);
		
		if (book == null) {
			response.setMessage("Fails created!");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setData(book);
			response.setMessage("Successfully created!");
			response.setStatus(HttpStatus.OK);
		}
		
		return response;
	}

	@Override
	public ApiBaseResponse<List<Book>> getAllBook() {
		// TODO Auto-generated method stub
		ApiBaseResponse<List<Book>> response = new ApiBaseResponse<>();
		
		List<Book> ltsBooks = bookRepository.findAll();
		
		response.setData(ltsBooks);
		response.setMessage("Successfully getted!");
		response.setStatus(HttpStatus.OK);
		
		return response;
	}

	@Override
	public ApiBaseResponse<Book> getById(String Id) {
		// TODO Auto-generated method stub
		log.info("Find Book By ID :: {}", Id);
		Book book = bookRepository.findById(Id)
				.orElseThrow(() -> new RuntimeException("Book not found"));
		ApiBaseResponse<Book> response = new ApiBaseResponse<>();
		response.setData(book);
		response.setMessage("Book found");
		response.setStatus(HttpStatus.OK);
		return response;
	}

	@Override
	public ApiBaseResponse<Book> deleteBookById(String Id) {
		// TODO Auto-generated method stub
		Book book = getById(Id).getData();
		bookRepository.delete(book);
		
		ApiBaseResponse<Book> response = new ApiBaseResponse<>();
		response.setData(book);
		response.setMessage("Deleted Successfully!");
		response.setStatus(HttpStatus.OK);
		
		return response;
	}
	
	

}
