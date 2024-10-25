package com.microservice.learn.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.microservice.learn.dto.CategoryDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "catagory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
	
	@Id
	private String id;
	private String name;
	private String description;
	
	public Category(CategoryDTO categoryDTO) {
		this.name = categoryDTO.getName();
		this.description = categoryDTO.getDescription();
	}
	
}
