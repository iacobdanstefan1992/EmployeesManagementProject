package com.employee.Controller;

import com.employee.Exception.ExceptionEmployee.EmployeeFirstNameException;
import com.employee.Exception.ExceptionEmployee.EmployeeFoundException;
import com.employee.Exception.ExceptionEmployee.EmployeeNotFoundException;
import com.employee.Mapper.EmployeeMapper;
import com.employee.Model.DAO.Employee;
import com.employee.Model.DTO.EmployeeDTO;
import com.employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import org.springframework.http.HttpHeaders;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeMapper employeeMapper;

    private static final Logger logger = Logger.getLogger(EmployeeController.class.getName());

    @PostMapping("/addEmployee") // This method will add a new employee in our database
    public Employee saveEmployee(@RequestBody Employee employee){
        Employee employee2;
        try{
            Employee employee1 = employeeService.findByWhereMethod(employee.getId());
            if(employee1 != null){
                logger.log(Level.WARNING,"This employee is in our database.");
                throw new EmployeeFoundException(employee.getId());
            }else if(employee.getFirstName().isEmpty() || employee.getLastName().isEmpty() || employee.getStartDate().toString().isEmpty() ||
                    employee.getEndDate().toString().isEmpty()){
                logger.log(Level.WARNING,"One of the fields is empty.");
                throw new EmployeeNotFoundException(employee.getId());
            }else{
                logger.log(Level.INFO,"A new employee was added.");
                employee2 = this.employeeService.saveEmployee(employee);
            }
        }catch (NoSuchElementException e){
                logger.log(Level.SEVERE,"Exception error : " + e);
                throw new EmployeeNotFoundException(employee.getId());
        }finally {
                logger.log(Level.INFO,"Method:addEmployee");
        }
        return employee2;
    }

    @PutMapping("/updateEmployee/{id_employee}") // This method will update an employee from our database
    public void updateEmployee(@RequestBody EmployeeDTO employee, @PathVariable int id_employee){
        Employee employee2;
        try{
            Employee employee1 = employeeService.findEmployeeById(employee.getId());
            if(employee1 == null){
                logger.log(Level.WARNING,"This employee is not in our database.");
                throw new EmployeeNotFoundException(employee.getId());
            }else{
                logger.log(Level.INFO,"A new employee was updated.");
                this.employeeService.updateEmployee(employee,id_employee);
            }
        }catch (NoSuchElementException e){
                logger.log(Level.SEVERE,"Exception error : " + e);
                throw new EmployeeNotFoundException(employee.getId());
        }
    }

    @DeleteMapping("/deleteEmployee/{id}") // This method will delete an employee from our database
    public void deleteEmployee(@PathVariable int id){
        try{
            Employee employee1 = employeeService.findEmployeeById(id);
            if(employee1 == null){
                logger.log(Level.WARNING,"This employee is not in our database.");
                throw new EmployeeNotFoundException(id);
            }else{
                logger.log(Level.INFO,"An employee was deleted.");
                this.employeeService.deleteEmployeeById(id);
            }
        }catch (NoSuchElementException e){
            logger.log(Level.SEVERE,"Exception error : " + e);
            throw new EmployeeNotFoundException(id);
        }
    }

    @GetMapping("/getEmployee/{id}") // This method will get an employee from our database
    public Employee findEmployeeById(@PathVariable int id) throws IOException{
        Employee employee;
        try{
            Employee employee1 = employeeService.findByWhereMethod(id);
            if(employee1 == null){
                logger.log(Level.WARNING,"This employee is not in our database.");
                throw new EmployeeNotFoundException(id);
            }else{
                logger.log(Level.INFO,"An employee was found.");
                employee = this.employeeService.findEmployeeById(id);
            }
        }catch (NoSuchElementException e){
            logger.log(Level.WARNING,"This employee is not in our database.");
            throw new EmployeeNotFoundException(id);
        }
        return employee;
    }

    @GetMapping("/findEmployeeByFirstName/{firstName}") // This method will get an employee by first name from our database
    public Employee findEmployeeByFirstName(@PathVariable String firstName) throws IOException{
        Employee employee;
        try{
            logger.log(Level.INFO,"This employee is in our database.");
            employee = this.employeeService.findEmployeeByFirstName(firstName);
        }catch (NoSuchElementException e){
            logger.log(Level.WARNING,"This employee was not found.");
            throw new EmployeeFirstNameException(firstName);
        }
        return employee;
    }

    @GetMapping("/getAllEmployees") // This method will get all employees from our database
    public List<Employee> findAllEmployees(){
        List<Employee> employee;
        try{
            Employee employee1 = employeeService.findByWhereMethod(1);
            if(employee1 == null){
                logger.log(Level.WARNING,"No employees were found in our database.");
                throw new EmployeeNotFoundException(1);
            }else{
                logger.log(Level.INFO,"Employees were found.");
                employee = this.employeeService.findAllEmployees();
                return employee;
            }
        }catch (NoSuchElementException e){
            logger.log(Level.WARNING,"No employees were found in our database.");
            throw new EmployeeNotFoundException(1);
        }
    }

    @GetMapping("/orderByFirstName") // This method will sort all employees by first name from our database
    public ResponseEntity<List<Employee>> orderByFirstName(){
        List<Employee> employee;
        try{
            logger.log(Level.INFO,"These employees are in our database.");
            employee = this.employeeService.OrderByFirstName();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Responded","orderByFirstName");
            return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).body(employee);
        }catch (NoSuchElementException e){
            logger.log(Level.WARNING,"These employees were not found.");
            throw new EmployeeFirstNameException("default");
        }
    }

    @GetMapping("/findByWhereMethod/{id}") // This method will find an employee from our database
    public ResponseEntity<Employee> findByWhereMethod(@PathVariable int id){
        Employee employee;
        try{
            logger.log(Level.INFO,"This employee is in our database.");
            employee = this.employeeService.findByWhereMethod(id);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Responded","findByWhereMethod");
            return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).body(employee);
        }catch (NoSuchElementException e){
            logger.log(Level.WARNING,"This employee was not found.");
            throw new EmployeeNotFoundException(id);
        }
    }

    @GetMapping("/getEmployeeDtoById/{id}") // This method will find an employee by id from our database
    public ResponseEntity<EmployeeDTO> getEmployeeDtoById(@PathVariable int id){
        Employee employee;
        EmployeeDTO employee1;
        try{
            employee = this.employeeService.findEmployeeById(id);
            employee1 = this.employeeMapper.convertToEmployeeDTO(employee);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Responded","getEmployeeDtoById");
            return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).body(employee1);
        }catch (NoSuchElementException e){
            logger.log(Level.WARNING,"This employee was not found.");
            throw new EmployeeNotFoundException(id);
        }
    }

    @GetMapping("/getAllEmployeesDTO") // This method will find all employees from our database
    public List<EmployeeDTO> getAllEmployeesDTO(){
        List<Employee> employees;
        List<EmployeeDTO> employees1;
        try{
            employees = this.employeeService.findAllEmployees();
            employees1 = employees.stream().map(u-> this.employeeMapper.convertToEmployeeDTO(u)).collect(Collectors.toList());
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Responded","getAllEmployeesDTO");
            ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).body(employees1);
            logger.log(Level.INFO,"These employees are in our database.");
            return employees1;
        }catch (NoSuchElementException e){
            logger.log(Level.WARNING,"No employees were found.");
            throw new EmployeeNotFoundException(1);
        }
    }

}
