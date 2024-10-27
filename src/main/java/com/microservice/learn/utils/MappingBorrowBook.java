package com.microservice.learn.utils;

import java.util.List;

import com.microservice.learn.dto.VisitorDTO;
import com.microservice.learn.entity.BorrowBook;
import com.microservice.learn.entity.Visitor;

public class MappingBorrowBook {
	
	public Visitor borrowBook (List<BorrowBook> book, VisitorDTO visitorDTO) {
		Visitor visitor = Visitor.builder()
				.name(visitorDTO.getName())
				.address(visitorDTO.getAddress())
				.gender(visitorDTO.getGender())
				.email(visitorDTO.getEmail())
				.phoneMumber(visitorDTO.getPhoneMumber())
				.startDate(visitorDTO.getStartDate())
				.endDate(visitorDTO.getEndDate())
				.borrowBook(book)
				.amongOfBook(getAmoungOfBook(book))
				.build();
		return visitor;
	}
	
	
	public int getAmoungOfBook(List<BorrowBook> lstBook) {
		int count = 0;
		if (lstBook.size() > 0) {
			for (BorrowBook bbBook : lstBook) {
				count += bbBook.getBookCount();
			}
		}
		return count;
	}
	
}
