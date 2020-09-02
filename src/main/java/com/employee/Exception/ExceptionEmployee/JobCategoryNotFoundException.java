package com.employee.Exception.ExceptionEmployee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class JobCategoryNotFoundException extends RuntimeException { // This exception is for the job category id

    public JobCategoryNotFoundException(int id){
        super("JobCategory id was not found!");
    }

}
