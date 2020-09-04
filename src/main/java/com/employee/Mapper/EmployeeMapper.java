package com.employee.Mapper;

import com.employee.Model.DAO.Employee;
import com.employee.Model.DTO.EmployeeDTO;
import com.employee.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper { // This mapper is used to take some information from another entity

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeDTO convertToEmployeeDTO(Employee employee){

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setDepartment(employee.getDepartment().getDepartmentId());
        employeeDTO.setJobCategory(employee.getJobCategory().getJobCategoryId());
        employeeDTO.setStartDate(employee.getStartDate());
        employeeDTO.setEndDate(employee.getEndDate());
        employeeDTO.setIsManager(employee.getIsManager());
        employeeDTO.setActive(employee.getActive());
        employeeDTO.setAddress(employee.getAddress());
        employeeDTO.setBirthday(employee.getBirthday());
        employeeDTO.setCp(employee.getCp());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setFullName(employee.getFullName());
        employeeDTO.setHasDrivingLicence(employee.getHasDrivingLicence());
        employeeDTO.setNoChildren(employee.getNoChildren());
        employeeDTO.setSalary(employee.getSalary());
        employeeDTO.setSocialSecurityNumber(employee.getSocialSecurityNumber());
        employeeDTO.setStudies(employee.getStudies());
        employeeDTO.setTelephone(employee.getTelephone());

        return employeeDTO;
    }
}
