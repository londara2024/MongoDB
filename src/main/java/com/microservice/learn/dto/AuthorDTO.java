package com.microservice.learn.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {
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
}
