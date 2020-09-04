package com.employee.Mapper;

import com.employee.Model.DAO.Employee;
import com.employee.Model.DAO.JobCategory;
import com.employee.Model.DTO.JobCategoryDTO;
import com.employee.Repository.JobCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JobCategoryMapper { // This mapper is used to take some information from another entity
    @Autowired
    private JobCategoryRepository jobCategoryRepository;

    public JobCategoryDTO convertToJobCategoryDTO(JobCategory jobCategory){

        JobCategoryDTO jobCategoryDTO = new JobCategoryDTO();
        List<String> employees = jobCategory.getEmployees().stream().map(Employee::getFullName).collect(Collectors.toList());

        jobCategoryDTO.setName(jobCategory.getJobCategoryName());
        jobCategoryDTO.setId(jobCategory.getJobCategoryId());
        jobCategoryDTO.setEmployees(employees);

        return jobCategoryDTO;
    }
}
