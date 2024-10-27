package com.microservice.learn.entity;


import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BorrowBook {
	private Integer bookCount;
	private Book book;
	private BigDecimal total;
}
