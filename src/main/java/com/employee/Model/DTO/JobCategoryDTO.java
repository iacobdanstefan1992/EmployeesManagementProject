package com.employee.Model.DTO;

import java.util.List;

public class JobCategoryDTO { // This table will get some information from JobCategory Table
    private String jobCategoryName;
    private List<String> employees;

    public JobCategoryDTO(String jobCategoryName, List<String> employees) {
        this.jobCategoryName = jobCategoryName;
        this.employees = employees;
    }

    public JobCategoryDTO(){}

    public String getJobCategoryName() {
        return jobCategoryName;
    }

    public void setJobCategoryName(String jobCategoryName) {
        this.jobCategoryName = jobCategoryName;
    }

    public List<String> getEmployees() {
        return employees;
    }

    public void setEmployees(List<String> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "JobCategoryDTO{" +
                "jobCategoryName='" + jobCategoryName + '\'' +
                ", employees=" + employees +
                '}';
    }
}
