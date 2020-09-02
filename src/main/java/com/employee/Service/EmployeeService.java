package com.employee.Service;

import com.employee.Model.DAO.Employee;
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

    public Employee updateEmployee(Employee employee, int id){
        Employee employee2 = this.employeeRepository.findById(id).get();

        if(employee2 != null){
            employee.setId(id);
            return this.employeeRepository.save(employee);
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
