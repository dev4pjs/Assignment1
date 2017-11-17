package com.assignment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.assignment.beans.ErrorResponse;

// We can write multiple Controller Adivce class for each layer or diff packages.
// For simplicity, implemented generic one.
@Component
@ControllerAdvice()
public class MyAppControllerAdvice {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	/*
	 * We can implement multiple ExceptionHandler method to handle diff kind of exceptions. 
	 * For simplicity implemented one to handle all kinds of exceptions
	 */
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<ErrorResponse> handleAllException(Exception ex){
		logger.error(ex.getMessage()+" :: "+ex.getStackTrace());
		ErrorResponse errorRes = new ErrorResponse();
		errorRes.setErroCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		errorRes.setErrorMessage(ex.getMessage());
		errorRes.setErrorDescription("Exception Descrition goes here");
		return new ResponseEntity<ErrorResponse>(errorRes,HttpStatus.INTERNAL_SERVER_ERROR);
	} 

}
