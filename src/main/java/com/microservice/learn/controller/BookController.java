package com.microservice.learn.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.learn.dto.BookDTO;
import com.microservice.learn.entity.Book;
import com.microservice.learn.service.BookService;
import com.microservice.learn.utils.ApiBaseResponse;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BookController {
	
	private final BookService bookService;
	
	@GetMapping("/book/all")
	public ResponseEntity<ApiBaseResponse<List<Book>>> getAllBook(){
		return ResponseEntity.ok(bookService.getAllBook());
	}
	
	@PostMapping("/book/post")
	public ResponseEntity<ApiBaseResponse<Book>> createBook (@RequestBody BookDTO bookDTO) {
		return ResponseEntity.ok(bookService.postBook(bookDTO));
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<ApiBaseResponse<Book>> getBookById (@PathVariable String id) {
		return ResponseEntity.ok(bookService.getById(id));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiBaseResponse<Book>> deleteBookById (@PathVariable String id) {
		return ResponseEntity.ok(bookService.deleteBookById(id));
	}

	
}
