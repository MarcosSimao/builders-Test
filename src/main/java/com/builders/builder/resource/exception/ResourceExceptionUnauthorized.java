package com.builders.builder.resource.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import com.builders.builder.service.exception.ObjectUnauthorizedException;

@ControllerAdvice
public class ResourceExceptionUnauthorized {
	 @ExceptionHandler(ObjectUnauthorizedException.class)
	 public ResponseEntity<StandardError> objectNotFound(ObjectUnauthorizedException e,HttpServletRequest request){
			HttpStatus status = HttpStatus.UNAUTHORIZED;
			StandardError erro = new StandardError(System.currentTimeMillis(),status.value(),"acesso invalido!!",e.getMessage(),request.getRequestURI());
			
			
			return ResponseEntity.status(status).body(erro);

}
}
