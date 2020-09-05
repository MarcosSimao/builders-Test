package com.builders.builder.resource.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.builders.builder.service.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandles {
    @ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e,HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError erro = new StandardError(System.currentTimeMillis(),status.value(),"nao Encontrado!!",e.getMessage(),request.getRequestURI());
		
		
		return ResponseEntity.status(status).body(erro);
		
		
		
	}
	
	
}
