package com.microservice.learn.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.microservice.learn.dto.BookDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	@Id
	private String id;
	private String bookTitle;
	private String bookDecs;
	private String author;
	private String createDate;
	private BigDecimal bookPrice;
	
	public Book (BookDTO bookDTO) {
		this.bookTitle = bookDTO.getBookTitle();
		this.bookDecs = bookDTO.getBookDecs();
		this.author = bookDTO.getAuthor();
		this.createDate = bookDTO.getCreateDate();
		this.bookPrice = bookDTO.getBookPrice();
	}
}
