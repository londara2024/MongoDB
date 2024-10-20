package com.microservice.learn.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.microservice.learn.dto.AuthorDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "author")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
	@Id
	private String id;
	private String fristName;
	private String lastName;
	private String middleName;
	private String personalStutas;
	private String bristDate;
	private String address;
	private String email;
	private String phoneNumber;
	private String profile;
	private BigDecimal earnPerMonth;
	
	
	public Author(AuthorDTO authorDTO) {
		this.fristName = authorDTO.getFristName();
		this.lastName  = authorDTO.getLastName();
		this.middleName = authorDTO.getMiddleName();
		this.personalStutas = authorDTO.getPersonalStutas();
		this.bristDate = authorDTO.getBristDate();
		this.address = authorDTO.getAddress();
		this.email = authorDTO.getEmail();
		this.phoneNumber = authorDTO.getPhoneNumber();
		this.profile = authorDTO.getProfile();
		this.earnPerMonth = authorDTO.getEarnPerMonth();
	}
}
