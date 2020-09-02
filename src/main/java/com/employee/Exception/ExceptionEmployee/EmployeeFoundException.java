package com.employee.Exception.ExceptionEmployee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeFoundException extends RuntimeException { // This exception is for the employee id, if it is found

    public EmployeeFoundException(int id){
        super("Employee id was found : "+id);
    }

}

