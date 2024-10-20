package com.microservice.learn.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.learn.dto.AuthorDTO;
import com.microservice.learn.entity.Author;
import com.microservice.learn.service.AuthorService;
import com.microservice.learn.utils.ApiBaseResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthorController {

	private final AuthorService authorService;
	
	@PostMapping("/author/create")
	public ResponseEntity<ApiBaseResponse<Author>> creatAuthor(@RequestBody AuthorDTO authorDTO){
		return ResponseEntity.ok(authorService.createAuthor(authorDTO));
	}
	
	@GetMapping("/author/all")
	public ResponseEntity<ApiBaseResponse<List<Author>>> getAllAuthor(){
		return ResponseEntity.ok(authorService.getAllAuthor());
	}
	
	@GetMapping("/author/{id}")
	public ResponseEntity<ApiBaseResponse<Author>> getAuthorById (@PathVariable String id) {
		return ResponseEntity.ok(authorService.getAuthorById(id));
	}
	
	@PutMapping("/author/update/{id}")
	public ResponseEntity<ApiBaseResponse<Author>> updateAuthor (@PathVariable String id, 
		@RequestBody AuthorDTO authorDTO) {
		return ResponseEntity.ok(authorService.updateAuthor(id, authorDTO));
	}
	
	@DeleteMapping("/author/delete/{id}")
	public ResponseEntity<ApiBaseResponse<Author>> deleteAuthor (@PathVariable String id) {
		return ResponseEntity.ok(authorService.deleteAuthor(id));
	}
}

















