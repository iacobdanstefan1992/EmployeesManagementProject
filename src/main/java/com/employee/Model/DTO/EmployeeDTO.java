package com.employee.Model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;

public class EmployeeDTO { // This table will get some information from Employee Table
    private String firstName;
    private String lastName;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private int department;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private int jobCategory;
    private LocalDate startDate;
    private LocalDate endDate;
    private int isManager;
    private int active;

    public EmployeeDTO(String firstName, String lastName, int department, int jobCategory, LocalDate startDate, LocalDate endDate, int isManager, int active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.jobCategory = jobCategory;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isManager = isManager;
        this.active = active;
    }

    public EmployeeDTO(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(int jobCategory) {
        this.jobCategory = jobCategory;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getIsManager() {
        return isManager;
    }

    public void setIsManager(int isManager) {
        this.isManager = isManager;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", jobCategory=" + jobCategory +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", isManager=" + isManager +
                ", active=" + active +
                '}';
    }
}
