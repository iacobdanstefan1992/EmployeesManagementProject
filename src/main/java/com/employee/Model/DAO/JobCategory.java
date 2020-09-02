package com.employee.Model.DAO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "jobCategory")
public class JobCategory { // The JobCategory Table show us job category id and job category name

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_category_id")
    private int jobCategoryId;
    @Column(name = "job_category_name")
    private String jobCategoryName;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "jobCategory")
    private List<Employee> employees;

    public JobCategory(int jobCategoryId, String jobCategoryName, List<Employee> employees) {
        super();
        this.jobCategoryId = jobCategoryId;
        this.jobCategoryName = jobCategoryName;
        this.employees = employees;
    }

    public JobCategory() {
        super();
    }

    public int getJobCategoryId() {
        return jobCategoryId;
    }

    public void setJobCategoryId(int jobCategoryId) {
        this.jobCategoryId = jobCategoryId;
    }

    public String getJobCategoryName() {
        return jobCategoryName;
    }

    public void setJobCategoryName(String jobCategoryName) {
        this.jobCategoryName = jobCategoryName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return String.valueOf(jobCategoryId);
    }
}
