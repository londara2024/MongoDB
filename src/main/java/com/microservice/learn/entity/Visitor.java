package com.microservice.learn.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Document(collection = "visitor")
@Data
@AllArgsConstructor
@Builder
public class Visitor {
	@Id
	private String id;
	private String name;
	private String address;
	private String gender;
	private String email;
	private String phoneMumber;
	private String startDate;
	private String endDate;
	private List<BorrowBook> borrowBook; 
	private Integer amongOfBook;
}
