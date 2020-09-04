package com.employee.Mapper;

import com.employee.Model.DAO.Department;
import com.employee.Model.DAO.Employee;
import com.employee.Model.DTO.DepartmentDTO;
import com.employee.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DepartmentMapper { // This mapper is used to take some information from another entity

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentDTO convertToDepartmentDTO(Department department){

        DepartmentDTO departmentDTO = new DepartmentDTO();
        List<String> employees = department.getEmployees().stream().map(Employee::getFullName).collect(Collectors.toList());

        departmentDTO.setName(department.getDepartmentName());
        departmentDTO.setId(department.getDepartmentId());
        departmentDTO.setEmployees(employees);

        return departmentDTO;
    }

}
