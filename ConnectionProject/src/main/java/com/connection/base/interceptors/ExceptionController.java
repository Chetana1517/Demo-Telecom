package com.connection.base.interceptors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value=RecordNotFoundException.class)
	public ResponseEntity<Object> exception(RecordNotFoundException e){
		return new ResponseEntity<Object>("Connection Not Found",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value= ClassNotGetException.class)
	public ResponseEntity<Object> exception(ClassNotGetException e){
		return new ResponseEntity<Object>
		("Delete By given Id is not Possible due to record not found for given id", HttpStatus.NOT_FOUND );
				
	}
	
	
	
}
