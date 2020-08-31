package com.cg.movie.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;

public class ValidateBookingException extends Exception{
	List<FieldError> errorList= new ArrayList<>();
	
	public ValidateBookingException() {
		super();
	}

	public ValidateBookingException(String arg0) {
		super(arg0);
		}

	public ValidateBookingException(List<FieldError> errorList) {
		super();
		this.errorList = errorList;
	}

	public List<FieldError> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<FieldError> errorList) {
		this.errorList = errorList;
	}


}
