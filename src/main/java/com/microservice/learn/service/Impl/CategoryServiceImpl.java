package com.microservice.learn.service.Impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.microservice.learn.dto.CategoryDTO;
import com.microservice.learn.entity.Category;
import com.microservice.learn.repository.CategoryRepository;
import com.microservice.learn.service.CategoryService;
import com.microservice.learn.utils.ApiBaseResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
	
	private final CategoryRepository categoryRepository;
	
	@Override
	public ApiBaseResponse<Category> createCategory(CategoryDTO categoryDTO) {
		// TODO Auto-generated method stub
		
		Category category = new Category(categoryDTO);
		category = categoryRepository.save(category);
		
		return responseObject("Inserted Successfully!!!", category);
	}

	@Override
	public ApiBaseResponse<Category> getById(String Id) {
		// TODO Auto-generated method stub

		Category category = categoryRepository.findById(Id)
				.orElseThrow(() -> new RuntimeException("ID { " + Id + " } Not found"));
		
		return responseObject("Selected Successfully!!!", category);
	}

	@Override
	public ApiBaseResponse<List<Category>> getAllCategory() {
		// TODO Auto-generated method stub
		
		List<Category> lstCategories = categoryRepository.findAll();
		return responseListObject("All Data", lstCategories);
	}

	@Override
	public ApiBaseResponse<Category> deleteCategory(String Id) {
		// TODO Auto-generated method stub
		
		Category category = getById(Id).getData();
		categoryRepository.delete(category);
		
		return responseObject("Deleted Successfully!!!", category);
	}

	@Override
	public ApiBaseResponse<Category> updateCategory(String Id, CategoryDTO categoryDTO) {
		// TODO Auto-generated method stub
		Category category = getById(Id).getData();
		
		if (verifyEmptyString(categoryDTO.getName())) {
			category.setName(categoryDTO.getName());
		}
		
		if (verifyEmptyString(categoryDTO.getDescription())) {
			category.setDescription(categoryDTO.getDescription());
		}
		
		category = categoryRepository.save(category);
		
		return responseObject("Updated Successfully!!!", category);
	}
	
	private ApiBaseResponse<Category> responseObject (String message, Category obj){
		
		ApiBaseResponse<Category> response = new ApiBaseResponse<>();
		
		response.setData(obj);
		response.setMessage(message);
		response.setStatus(HttpStatus.OK);
		
		return response;
	}
	
	private ApiBaseResponse<List<Category>> responseListObject (String message, List<Category> obj){
		
		ApiBaseResponse<List<Category>> response = new ApiBaseResponse<>();
		
		response.setData(obj);
		response.setMessage(message);
		response.setStatus(HttpStatus.OK);
		
		return response;
	}
	
	private Boolean verifyEmptyString(String str) {
		if (str.isEmpty() || str.trim().isEmpty()) {
			return false;
		}
		return true;
	}
	
	
}
