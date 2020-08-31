package com.cg.movie.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.cg.dto.ErrorMessage;
import com.cg.movie.exceptions.BookingException;
import com.cg.movie.exceptions.ShowException;
import com.cg.movie.exceptions.ValidateBookingException;

@RestControllerAdvice
public class BookingAdvice {
	@ExceptionHandler(ShowException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorMessage handleSearchException(ShowException ex) {
		return new ErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage());
	}
	
	
	@ExceptionHandler(BookingException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorMessage handleException1(BookingException ex) {
		return new ErrorMessage(HttpStatus.NOT_FOUND.toString(),ex.getMessage());
	}
	
	@ExceptionHandler(ValidateBookingException.class)
	@ResponseStatus(code = HttpStatus.FORBIDDEN)
	public ErrorMessage handleException3(ValidateBookingException ex) {
		List<String> errors= ex.getErrorList().stream().map(err-> err.getDefaultMessage()).collect(Collectors.toList());
		return new ErrorMessage(HttpStatus.FORBIDDEN.toString(), errors);
	}
	@ExceptionHandler(HttpMessageConversionException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorMessage handleException4(HttpMessageConversionException ex) {
		if(ex.getMessage().contains("doj"))
		return new ErrorMessage(HttpStatus.BAD_REQUEST.toString(),"Invalid date pattern, follow yyyy-M-d");
	return new ErrorMessage(HttpStatus.BAD_REQUEST.toString(), ex.getMessage());
	}

}
