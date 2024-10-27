package com.microservice.learn.service.Impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.microservice.learn.dto.BorrowBookDTO;
import com.microservice.learn.dto.VisitorDTO;
import com.microservice.learn.entity.Book;
import com.microservice.learn.entity.BorrowBook;
import com.microservice.learn.entity.Visitor;
import com.microservice.learn.repository.VisitorRepository;
import com.microservice.learn.service.BookService;
import com.microservice.learn.service.VisitorService;
import com.microservice.learn.utils.ApiBaseResponse;
import com.microservice.learn.utils.MappingBorrowBook;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class VisitorResviceImpl implements VisitorService{
	
	private final VisitorRepository visitorRepository;
	
	private final BookService bookService;

	@Override
	public ApiBaseResponse<Visitor> enterNewVisitor(VisitorDTO visitorDTO) {
		// TODO Auto-generated method stub'
		MappingBorrowBook borrowBook = new MappingBorrowBook();
		
		List<BorrowBook> lstBooks = lstAllBorrowBook(visitorDTO.getBorrowBook());
		
		Visitor visitor = borrowBook.borrowBook(lstBooks, visitorDTO);
		visitor = visitorRepository.save(visitor);
		log.info("visitor {}", visitor);
		
		return reponseObject("Created Successfully!!!", visitor);
	}

	@Override
	public ApiBaseResponse<List<Visitor>> getAllVisitor() {
		// TODO Auto-generated method stub
		List<Visitor> lstVisitors = visitorRepository.findAll();
		return reponseListObject("Seleted All Successfully!!", lstVisitors);
	}

	@Override
	public ApiBaseResponse<Visitor> getVisitorById(String Id) {
		// TODO Auto-generated method stub
		Visitor visitor = visitorRepository.findById(Id)
				.orElseThrow(() -> new RuntimeException("Visitor ID : { " + Id + " } is found!!!"));
		return reponseObject("Selected By ID :: { " + Id + " } Successfuuly!!!", visitor);
	}

	@Override
	public ApiBaseResponse<Visitor> deleteVisitoById(String Id) {
		// TODO Auto-generated method stub
		Visitor visitor = getVisitorById(Id).getData();
		visitorRepository.delete(visitor);
		
		return  reponseObject("Deleted By ID :: { " + Id + " } Successfuuly!!!", visitor);
	}
	
	@Override
	public Page<Visitor> listVisitorPagination(Pageable p) {
		// TODO Auto-generated method stub
		return visitorRepository.findAll(p);
	}
	
	private ApiBaseResponse<Visitor> reponseObject (String message, Visitor visitor){
		ApiBaseResponse<Visitor> response = new ApiBaseResponse<>();
		
		response.setData(visitor);
		response.setMessage(message);
		response.setStatus(HttpStatus.OK);
		
		return response;
	}
	
	private ApiBaseResponse<List<Visitor> > reponseListObject (String message, List<Visitor> visitor){
		ApiBaseResponse<List<Visitor> > response = new ApiBaseResponse<>();
		
		response.setData(visitor);
		response.setMessage(message);
		response.setStatus(HttpStatus.OK);
		
		return response;
	}
	
	private List<BorrowBook> lstAllBorrowBook(List<BorrowBookDTO> lstBook){
		
		List<BorrowBook> lsBooks = new ArrayList<>();
		
		if (lstBook.size() > 0) {
			for (BorrowBookDTO bb : lstBook) {
				Book book = bookService.getById(bb.getLstBooksId()).getData();
				BorrowBook borrowBook = BorrowBook.builder()
						.book(book)
						.bookCount(bb.getBookCount())
						.total(getTotal(bb.getBookCount(), book.getBookPrice()))
						.build();
				lsBooks.add(borrowBook);
			}
			
			return lsBooks;
		}
		
		return null;
	}
	
	private BigDecimal getTotal (int bookCount, BigDecimal priceBook) {
		if ( (bookCount > 0) && (priceBook.compareTo(BigDecimal.ZERO) > 0)) {
			return priceBook.multiply(BigDecimal.valueOf(bookCount)); 
		}
		return null;
	}

	

}
