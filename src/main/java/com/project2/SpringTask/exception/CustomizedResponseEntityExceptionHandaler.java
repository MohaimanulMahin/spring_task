package com.project2.SpringTask.exception;

import com.project2.SpringTask.dto.ExceptionResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandaler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> handleAllException(Exception ex,WebRequest request){
    ExceptionResponse exceptionResponse= new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(true));
   return new ResponseEntity(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
  }
  @ExceptionHandler(EmployeeNotFoundException.class)
  public final ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException ex,WebRequest request){
    ExceptionResponse exceptionResponse= new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(true));
   return new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);
  }
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(),ex.getMessage(),ex.getBindingResult().getAllErrors().toString());
    return new ResponseEntity<>(exceptionResponse,HttpStatus.GATEWAY_TIMEOUT);
  }
}
