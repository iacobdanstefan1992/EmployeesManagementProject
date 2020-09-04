package com.employee.Model.DTO;

import java.util.List;

public class JobCategoryDTO { // This table will get some information from JobCategory Table
    private int id;
    private String name;
    private List<String> employees;

    public JobCategoryDTO(int id, String name, List<String> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    public JobCategoryDTO(){}

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
        return "JobCategoryDTO{" +
                ", id=" + id +
                ", name=" + name +
                ", employees=" + employees +
                '}';
    }
}
