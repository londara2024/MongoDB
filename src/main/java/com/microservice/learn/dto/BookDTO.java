package com.microservice.learn.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
	private String bookTitle;
	private String bookDecs;
	private String author;
	private String createDate;
	private BigDecimal bookPrice;
}
