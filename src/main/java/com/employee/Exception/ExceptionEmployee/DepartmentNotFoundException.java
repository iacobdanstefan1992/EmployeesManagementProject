package com.employee.Exception.ExceptionEmployee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DepartmentNotFoundException extends RuntimeException { // This exception is for the department id

    public DepartmentNotFoundException(int id){
        super("Department id was not found!");
    }

}
