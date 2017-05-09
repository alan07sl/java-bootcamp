package com.globant.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ErrorMessage> somethingWentWrong(Exception ex) {
		ErrorMessage exceptionResponse = new ErrorMessage(ex.getMessage(), "This is a test to give a description of a custom exception I've thrown.");

		return new ResponseEntity<ErrorMessage>(exceptionResponse, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

	class ErrorMessage {
		private String message;
		private String details;

		public ErrorMessage() {
		}

		public ErrorMessage(String message, String details) {
			super();
			this.message = message;
			this.details = details;
		}

		public String getMessage() {
			return message;
		}
		
		public void setMessage(String message) {
			this.message = message;
		}
		
		public String getDetails() {
			return details;
		}
		
		public void setDetails(String details) {
			this.details = details;
		}
	}
}
