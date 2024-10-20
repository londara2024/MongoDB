package com.microservice.learn.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;

import lombok.*;


@Data
@AllArgsConstructor
public class ApiBaseResponse<T> {
	private T Data;
	private String message;
	private HttpStatus status;
	private String dateTime;
	
    public ApiBaseResponse() {
        setDateTime();
    }
    
    private void setDateTime() {
        // create an LocalDateTime object
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        setDateTime(now.format(format));
    }
}
