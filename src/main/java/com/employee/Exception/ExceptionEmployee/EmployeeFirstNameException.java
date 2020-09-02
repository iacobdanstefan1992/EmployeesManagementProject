package com.employee.Exception.ExceptionEmployee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeFirstNameException extends RuntimeException { // This exception is for the employee first name

    public EmployeeFirstNameException(String firstName){
        super("Employee First Name was not found : "+firstName);
    }

}

