package com.microservice.learn.entity;


import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BorrowBook {
	private Integer bookCount;
	private Book book;
	private BigDecimal total;
}
