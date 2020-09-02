package com.employee.Exception.ExceptionHandler;

import com.employee.Exception.ExceptionApi.ExceptionApi;
import com.employee.Exception.ExceptionEmployee.EmployeeFoundException;
import com.employee.Exception.ExceptionEmployee.EmployeeNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice // These exceptions are for overriding and exceptionHandler
public class ExceptionHandlerGen extends ResponseEntityExceptionHandler {
    private ResponseEntity<Object> buildResponseEntity(ExceptionApi exceptionApi){
        return new ResponseEntity<>(exceptionApi,exceptionApi.getHttpStatus());
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception e, HttpServletResponse response){
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        response.setStatus(httpStatus.value());
        return buildResponseEntity(new ExceptionApi(httpStatus,"Internal Server Error: Unexpected Exception",e));
    }
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFound(EmployeeNotFoundException ex, HttpServletResponse response){
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return buildResponseEntity(new ExceptionApi(httpStatus,"Error! This Employee was not found!",ex));
    }
    @ExceptionHandler(EmployeeFoundException.class)
    public ResponseEntity<Object> handleEntityFound(EmployeeFoundException ex, HttpServletResponse response){
        HttpStatus httpStatus = HttpStatus.FOUND;
        return buildResponseEntity(new ExceptionApi(httpStatus,"Error! This Employee was found!",ex));
    }
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException en, HttpHeaders headers, HttpStatus httpStatus, WebRequest request){
        return buildResponseEntity(new ExceptionApi(HttpStatus.BAD_GATEWAY,"Not supported",en));
    }
}
