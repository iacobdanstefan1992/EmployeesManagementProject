package com.employee.Exception.ExceptionEmployee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class JobCategoryNameException extends RuntimeException { // This exception is for the job category name

    public JobCategoryNameException(String name){
        super("JobCategory Name was not found : "+name);
    }

}

