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

import com.microservice.learn.dto.CategoryDTO;
import com.microservice.learn.entity.Category;
import com.microservice.learn.service.CategoryService;
import com.microservice.learn.utils.ApiBaseResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CategoryController {

	private final CategoryService categoryService;
	
	@PostMapping("/category/post")
	public ResponseEntity<ApiBaseResponse<Category>> createdCategory (@RequestBody CategoryDTO categoryDTO) {
		return ResponseEntity.ok(categoryService.createCategory(categoryDTO));
	}
	
	@GetMapping("/category/All")
	public ResponseEntity<ApiBaseResponse<List<Category>>> getAllCategoryEntity () {
		return ResponseEntity.ok(categoryService.getAllCategory());
	}
	
	@GetMapping("/category/{id}")
	public ResponseEntity<ApiBaseResponse<Category>> getCategoryById (@PathVariable("id") String Id) {
		return ResponseEntity.ok(categoryService.getById(Id));
	}
	
	@PutMapping("/category/update/{id}")
	public ResponseEntity<ApiBaseResponse<Category>> updatedCategoryById(@PathVariable String id, 
			@RequestBody CategoryDTO categoryDTO) {
		return ResponseEntity.ok(categoryService.updateCategory(id, categoryDTO));
	}
	
	@DeleteMapping("/category/delete/{id}")
	public ResponseEntity<ApiBaseResponse<Category>> deletedCategoryById(@PathVariable String id) {
		return ResponseEntity.ok(categoryService.deleteCategory(id));
	}
}
