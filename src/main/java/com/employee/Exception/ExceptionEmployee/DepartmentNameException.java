package com.employee.Exception.ExceptionEmployee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DepartmentNameException extends RuntimeException { // This exception is for the department name

    public DepartmentNameException(String name){
        super("Department Name was not found : "+name);
    }

}
