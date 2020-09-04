package com.employee.Model.DTO;

import java.util.List;

public class DepartmentDTO { // This table will get some information from Department Table
    private int id;
    private String name;
    private List<String> employees;

    public DepartmentDTO(int id, String name, List<String> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    public DepartmentDTO(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
