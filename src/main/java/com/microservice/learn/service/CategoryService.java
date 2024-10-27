package com.microservice.learn.service;

import java.util.List;

import com.microservice.learn.dto.CategoryDTO;
import com.microservice.learn.entity.Category;
import com.microservice.learn.utils.ApiBaseResponse;

public interface CategoryService {
	ApiBaseResponse<Category> createCategory (CategoryDTO categoryDTO);
	ApiBaseResponse<Category> getById (String Id);
	ApiBaseResponse<List<Category>> getAllCategory ();
	ApiBaseResponse<Category> deleteCategory (String Id);
	ApiBaseResponse<Category> updateCategory (String Id, CategoryDTO categoryDTO);
}
