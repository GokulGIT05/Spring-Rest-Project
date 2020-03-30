package com.gk5.globalexception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gk4.exception.handler.StudentExceptionResponse;
import com.gk4.exception.handler.StudentNotFoundException;

@ControllerAdvice
public class StudentRestGlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<StudentExceptionResponse> throwProperErrorMessage(StudentNotFoundException errorMessage){
		StudentExceptionResponse errorResponse = new StudentExceptionResponse();
		
		errorResponse.setErrorCode(HttpStatus.NOT_FOUND.value());
		errorResponse.setErrorMessage(errorMessage.getMessage());
		
		
		return new ResponseEntity<StudentExceptionResponse>(errorResponse,HttpStatus.NOT_FOUND);
	}

	

	@ExceptionHandler
	public ResponseEntity<StudentExceptionResponse> throwGlobalException(Exception errorMessage){
		StudentExceptionResponse errorResponse = new StudentExceptionResponse();
		
		errorResponse.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorResponse.setErrorMessage(errorMessage.getMessage());
		
		return new ResponseEntity<StudentExceptionResponse>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	

}
