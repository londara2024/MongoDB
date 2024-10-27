package com.microservice.learn.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitorDTO {
	private String name;
	private String address;
	private String gender;
	private String email;
	private String phoneMumber;
	private String startDate;
	private String endDate;
	private List<BorrowBookDTO> borrowBook; 
}
