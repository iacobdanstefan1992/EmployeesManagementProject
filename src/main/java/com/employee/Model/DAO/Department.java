package com.employee.Model.DAO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department") // The Department Table show us department id and department name
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private int departmentId;
    @Column(name = "department_name")
    private String departmentName;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private List<Employee> employees;

    public Department(int departmentId, String departmentName, List<Employee> employees) {
        super();
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.employees = employees;
    }

    public Department() {
        super();
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return String.valueOf(departmentId);
    }
}
