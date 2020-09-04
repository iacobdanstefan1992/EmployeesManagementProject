package com.employee.Model.DAO;

import javax.persistence.*;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "employee")
public class Employee { // Here, I created a table with many columns with one primary key and two foreign keys

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "isManager")
    private int isManager;
    @Column(name = "startDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @Column(name = "endDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    @Column(name = "active")
    private int active;
    @Column(name = "address")
    private String address;
    @Column(name = "cp")
    private String cp;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "email")
    private String email;
    @Column(name = "birthday")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    @Column(name = "noChildren")
    private int noChildren;
    @Column(name = "salary")
    private double salary;
    @Column(name = "studies")
    private String studies;
    @Column(name = "socialSecurityNumber")
    private String socialSecurityNumber;
    @Column(name = "has_driving_license")
    private int hasDrivingLicence;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "department_id")
    private Department department;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_category_id")
    private JobCategory jobCategory;
    @Column(name = "full_name")
    private String fullName;

    public Employee(int id, String firstName, String lastName, int isManager,
                    LocalDate startDate, LocalDate endDate, int active,
                    String address, String cp, String telephone, String email,
                    LocalDate birthday, int noChildren, double salary,
                    String studies, String socialSecurityNumber, int hasDrivingLicence,
                    Department department, JobCategory jobCategory, String fullName) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isManager = isManager;
        this.startDate = startDate;
        this.endDate = endDate;
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
        this.department = department;
        this.jobCategory = jobCategory;
        this.fullName = fullName;
    }

    public Employee(int id, String firstName, String lastName) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getIsManager() {
        return isManager;
    }

    public void setIsManager(int isManager) {
        this.isManager = isManager;
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

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public JobCategory getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(JobCategory jobCategory) {
        this.jobCategory = jobCategory;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", jobCategory=" + jobCategory +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", isManager=" + isManager +
                ", active=" + active +
                ", cp='" + cp + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", noChildren=" + noChildren +
                ", salary=" + salary +
                ", studies='" + studies + '\'' +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", hasDrivingLicence=" + hasDrivingLicence +
                ", fullName=" + fullName +
                '}';
    }
}
