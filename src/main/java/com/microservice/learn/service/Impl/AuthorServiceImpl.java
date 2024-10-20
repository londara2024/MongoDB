package com.microservice.learn.service.Impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.microservice.learn.dto.AuthorDTO;
import com.microservice.learn.entity.Author;
import com.microservice.learn.repository.AuthorRepository;
import com.microservice.learn.service.AuthorService;
import com.microservice.learn.utils.ApiBaseResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService{
	
	private final AuthorRepository authorRepository;

	@Override
	public ApiBaseResponse<Author> createAuthor(AuthorDTO authorDTO) {
		// TODO Auto-generated method stub
		ApiBaseResponse<Author> response = new ApiBaseResponse<>();
		
		Author author = new Author(authorDTO);
		author = authorRepository.save(author);
		
		response.setData(author);
		response.setMessage("Successfully created!");
		response.setStatus(HttpStatus.OK);
		
		return response;
	}

	@Override
	public ApiBaseResponse<List<Author>> getAllAuthor() {
		// TODO Auto-generated method stub
		ApiBaseResponse<List<Author>> response = new ApiBaseResponse<>();
		
		List<Author> lstAuthors = authorRepository.findAll();
		
		response.setData(lstAuthors);
		response.setMessage("Find All Data!");
		response.setStatus(HttpStatus.OK);
		
		return response;
	}

	@Override
	public ApiBaseResponse<Author> getAuthorById(String Id) {
		// TODO Auto-generated method stub
		ApiBaseResponse<Author> response = new ApiBaseResponse<>();
		
		Author author = authorRepository.findById(Id)
				.orElseThrow(() -> new RuntimeException("Author not found!!!!"));
		
		response.setData(author);
		response.setMessage("Find By ID {" + Id + "} success.");
		response.setStatus(HttpStatus.OK);
		
		return response;
	}

	@Override
	public ApiBaseResponse<Author> deleteAuthor(String Id) {
		// TODO Auto-generated method stub
		ApiBaseResponse<Author> response = new ApiBaseResponse<>();
		
		Author author = getAuthorById(Id).getData();
		authorRepository.delete(author);
		
		response.setData(author);
		response.setMessage("Delete ID :: { " + Id + " } successful!!!");
		response.setStatus(HttpStatus.OK);
		
		return response;
	}

	@Override
	public ApiBaseResponse<Author> updateAuthor(String Id, AuthorDTO authorDTO) {
		// TODO Auto-generated method stub
		
		ApiBaseResponse<Author> response = new ApiBaseResponse<>();
		
		Author author = getAuthorById(Id).getData();
		
		if (!authorDTO.getAddress().isEmpty()) {
			author.setAddress(authorDTO.getAddress());
		}
		
		if (!authorDTO.getFristName().isEmpty()) {
			author.setFristName(authorDTO.getFristName());
		}
		
		if (!authorDTO.getLastName().isEmpty()) {
			author.setLastName(authorDTO.getLastName());
		}
		
		if (!authorDTO.getMiddleName().isEmpty()) {
			author.setMiddleName(authorDTO.getMiddleName());
		}
		
		if (!authorDTO.getPersonalStutas().isEmpty()) {
			author.setPersonalStutas(authorDTO.getPersonalStutas());
		}
		
		if (!authorDTO.getBristDate().isEmpty()) {
			author.setBristDate(authorDTO.getBristDate());
		}
		
		if (!authorDTO.getEmail().isEmpty()) {
			author.setEmail(authorDTO.getEmail());
		}
		
		if (!authorDTO.getPhoneNumber().isEmpty()) {
			author.setPhoneNumber(authorDTO.getPhoneNumber());
		}
		
		if (!authorDTO.getProfile().isEmpty()) {
			author.setProfile(authorDTO.getProfile());
		}
		
		if (author.getEarnPerMonth().compareTo(BigDecimal.ZERO) > 0) {
			author.setEarnPerMonth(authorDTO.getEarnPerMonth());
		}
		
		author = authorRepository.save(author);
		response.setData(author);
		response.setMessage("Update By ID { " + Id + " } is successfull!");
		response.setStatus(HttpStatus.OK);
		
		return response;
	}

}
