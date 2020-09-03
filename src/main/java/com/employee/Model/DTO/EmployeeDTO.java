package com.employee.Model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;

public class EmployeeDTO { // This table will get some information from Employee Table
    private int id;
    private String firstName;
    private String lastName;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private String department;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private String jobCategory;
    private LocalDate startDate;
    private LocalDate endDate;
    private int isManager;
    private int active;
    private String address;
    private String cp;
    private String telephone;
    private String email;
    private LocalDate birthday;
    private int noChildren;
    private double salary;
    private String studies;
    private String socialSecurityNumber;
    private int hasDrivingLicence;
    private String fullName;

    public EmployeeDTO(int id, String firstName, String lastName, String department, String jobCategory, LocalDate startDate, LocalDate endDate, int isManager, int active, String address, String cp, String telephone, String email, LocalDate birthday, int noChildren, double salary, String studies, String socialSecurityNumber, int hasDrivingLicence, String fullName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.jobCategory = jobCategory;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isManager = isManager;
        this.active = active;
        this.address = address;
        this.cp = cp;
        this.telephone = telephone;
        this.email = email;
        this.birthday = birthday;
        this.noChildren = noChildren;
        this.salary = salary;
        this.studies = studies;
        this.socialSecurityNumber = socialSecurityNumber;
        this.hasDrivingLicence = hasDrivingLicence;
        this.fullName = fullName;
    }

    public EmployeeDTO(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getNoChildren() {
        return noChildren;
    }

    public void setNoChildren(int noChildren) {
        this.noChildren = noChildren;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getStudies() {
        return studies;
    }

    public void setStudies(String studies) {
        this.studies = studies;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public int getHasDrivingLicence() {
        return hasDrivingLicence;
    }

    public void setHasDrivingLicence(int hasDrivingLicence) {
        this.hasDrivingLicence = hasDrivingLicence;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String jobCategory) {
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
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", jobCategory=" + jobCategory +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", isManager=" + isManager +
                ", active=" + active +
                ", address='" + address + '\'' +
                ", cp='" + cp + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", noChildren=" + noChildren +
                ", salary=" + salary +
                ", studies='" + studies + '\'' +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", hasDrivingLicence=" + hasDrivingLicence +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
