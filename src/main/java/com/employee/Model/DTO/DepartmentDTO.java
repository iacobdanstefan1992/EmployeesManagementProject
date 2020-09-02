package com.employee.Model.DTO;

import java.util.List;

public class DepartmentDTO { // This table will get some information from Department Table
    private String departmentName;
    private List<String> employees;

    public DepartmentDTO(String departmentName, List<String> employees) {
        this.departmentName = departmentName;
        this.employees = employees;
    }

    public DepartmentDTO(){}

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<String> getEmployees() {
        return employees;
    }

    public void setEmployees(List<String> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "departmentName='" + departmentName + '\'' +
                ", employees=" + employees +
                '}';
    }
}
