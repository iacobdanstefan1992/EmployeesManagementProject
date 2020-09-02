package com.employee.Exception.ExceptionEmployee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException { // This exception is for the employee id

    public EmployeeNotFoundException(int id){
        super("Employee id was not found : "+id);
    }

}
