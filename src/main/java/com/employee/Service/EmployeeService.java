package com.employee.Service;

import com.employee.Model.DAO.Employee;
import com.employee.Model.DTO.EmployeeDTO;
import com.employee.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // Here, I created methods for update, delete, get and getAll. These methods will aid me to manipulate data better.
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee){

        return this.employeeRepository.save(employee);
    }

    public void updateEmployee(EmployeeDTO employee, int id){
        Employee employee2 = this.employeeRepository.findById(id).get();

        if(employee2 != null){
            employee2.setId(employee.getId());
            employee2.setFirstName(employee.getFirstName());
            employee2.setLastName(employee.getLastName());
            employee2.setStartDate(employee.getStartDate());
            employee2.setEndDate(employee.getEndDate());
            employee2.setIsManager(employee.getIsManager());
            employee2.setActive(employee.getActive());
            employee2.setAddress(employee.getAddress());
            employee2.setBirthday(employee.getBirthday());
            employee2.setCp(employee.getCp());
            employee2.setEmail(employee.getEmail());
            employee2.setFullName(employee.getFullName());
            employee2.setHasDrivingLicence(employee.getHasDrivingLicence());
            employee2.setNoChildren(employee.getNoChildren());
            employee2.setSalary(employee.getSalary());
            employee2.setSocialSecurityNumber(employee.getSocialSecurityNumber());
            employee2.setStudies(employee.getStudies());
            employee2.setTelephone(employee.getTelephone());

            this.employeeRepository.save(employee2);
        }else{
            throw new RuntimeException("Employee was not found!");
        }
    }

    public void deleteEmployeeById(int id){
        this.employeeRepository.deleteById(id);
    }

    public Employee findEmployeeById(int id){
        return this.employeeRepository.findById(id).get();
    }

    public Employee findEmployeeByFirstName(String firstName){
        return this.employeeRepository.findByFirstName(firstName).get();
    }

    public List<Employee> findAllEmployees(){
        return this.employeeRepository.findAll();
    }

    public List<Employee> OrderByFirstName(){
        return this.employeeRepository.OrderByFirstName();
    }

    public Employee findByWhereMethod(int id){
        return this.employeeRepository.FindByWhereMethod(id);
    }
}
