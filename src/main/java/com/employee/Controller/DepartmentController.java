package com.employee.Controller;

import com.employee.Exception.ExceptionEmployee.*;
import com.employee.Mapper.DepartmentMapper;
import com.employee.Model.DAO.Department;
import com.employee.Model.DTO.DepartmentDTO;
import com.employee.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentMapper departmentMapper;

    private static final Logger logger = Logger.getLogger(DepartmentController.class.getName());

    @PostMapping("/addDepartment") // This method will add a new department in our database
    public Department saveDepartment(@RequestBody Department department){
        Department department1;
        Department department2;
        try{
            department1 = departmentService.findByWhereMethod(department.getDepartmentId());
            if(department1 != null ){
                logger.log(Level.WARNING,"This department is in our database.");
                throw new DepartmentNotFoundException(department.getDepartmentId());
            }else if(department.getDepartmentName().isEmpty()){
                logger.log(Level.WARNING,"One of the fields is empty.");
                throw new DepartmentNotFoundException(department.getDepartmentId());
            }else{
                logger.log(Level.INFO,"A new department was added.");
                department2 = this.departmentService.saveDepartment(department);
            }
        }catch (NoSuchElementException e){
            logger.log(Level.SEVERE,"Exception error : " + e);
            throw new DepartmentNotFoundException(department.getDepartmentId());
        }finally {
            logger.log(Level.INFO,"Method:addDepartment");
        }
        return department2;
    }

    @PutMapping("/updateDepartment/{id_department}") // This method will update a department from our database
    public Department updateDepartment(@RequestBody Department department, @PathVariable int id_department){
        Department department1;
        Department department2;
        try{
            department1 = departmentService.findDepartmentById(department.getDepartmentId());
            if(department1 == null){
                logger.log(Level.WARNING,"This department is not in our database.");
                throw new DepartmentNotFoundException(department.getDepartmentId());
            }else{
                logger.log(Level.INFO,"A new department was updated.");
                department2 = this.departmentService.updateDepartment(department, id_department);
            }
        }catch (NoSuchElementException e){
            logger.log(Level.SEVERE,"Exception error : " + e);
            throw new DepartmentNotFoundException(department.getDepartmentId());
        }
        return department2;
    }

    @DeleteMapping("/deleteDepartment/{id}") // This method will delete a department from our database
    public void deleteDepartment(@PathVariable int id){
        Department department;
        try{
            department = departmentService.findDepartmentById(id);
            if(department == null){
                logger.log(Level.WARNING,"This department is not in our database.");
                throw new DepartmentNotFoundException(id);
            }else{
                logger.log(Level.INFO,"A department was deleted.");
                this.departmentService.deleteDepartmentById(id);
            }
        }catch (NoSuchElementException e){
            logger.log(Level.SEVERE,"Exception error : " + e);
            throw new DepartmentNotFoundException(id);
        }
    }

    @GetMapping("/getDepartmentById/{id}") // This method will get a department from our database
    public Department findDepartmentById(@PathVariable int id) throws IOException{
        Department department;
        Department department1;
        try{
            department1 = departmentService.findByWhereMethod(id);
            if(department1 == null){
                logger.log(Level.WARNING,"This department is not in our database.");
                throw new DepartmentNotFoundException(id);
            }else{
                logger.log(Level.INFO,"A department was found.");
                department = this.departmentService.findDepartmentById(id);
            }
        }catch (NoSuchElementException e){
            logger.log(Level.SEVERE,"Exception error : " + e);
            throw new DepartmentNotFoundException(id);
        }
        return department;
    }

    @GetMapping("/getAllDepartments") // This method will get all departments from our database
    public List<Department> findAllDepartments(){
        List<Department> departments;
        Department department;
        try{
            department = departmentService.findByWhereMethod(1);
            if(department == null){
                logger.log(Level.WARNING,"No departments were found in our database.");
                throw new DepartmentNotFoundException(1);
            }else{
                logger.log(Level.INFO,"Departments were found.");
                departments = this.departmentService.findAllDepartments();
                return departments;
            }
        }catch (NoSuchElementException e){
            logger.log(Level.WARNING,"No departments were found in our database.");
            throw new DepartmentNotFoundException(1);
        }
    }

    @GetMapping("/findDepartmentsByOrderName") // This method will sort all departments by first name from our database
    public ResponseEntity<List<Department>> findDepartmentsByOrderName(){
        List<Department> departments;
        try{
            logger.log(Level.INFO,"These departments are in our database.");
            departments = this.departmentService.orderByDepartmentName();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Responded","findDepartmentsByOrderName");
            return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).body(departments);
        }catch (NoSuchElementException e){
            logger.log(Level.WARNING,"These departments were not found.");
            throw new DepartmentNameException("default");
        }
    }

    @GetMapping("/findDepartmentsByWhereMethod/{id}") // This method will find a department from our database
    public ResponseEntity<Department> findByWhereMethod(@PathVariable int id){
        Department department;
        try{
            logger.log(Level.INFO,"This department is in our database.");
            department = this.departmentService.findByWhereMethod(id);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Responded","findDepartmentsByWhereMethod");
            return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).body(department);
        }catch (NoSuchElementException e){
            logger.log(Level.WARNING,"This department was not found.");
            throw new DepartmentNotFoundException(id);
        }
    }

    @GetMapping("/getDepartmentDtoById/{id}") // This method will find a department by id from our database
    public ResponseEntity<String> getDepartmentDtoById(@PathVariable int id){
        Department department;
        DepartmentDTO department1;
        try{
            department = this.departmentService.findDepartmentById(id);
            department1 = this.departmentMapper.convertToDepartmentDTO(department);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Responded","getDepartmentDtoById");
            ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).body(department1);
            logger.log(Level.INFO,"This department is in our database.");
            return new ResponseEntity<String>("This department was found! \n" +
                    "Department Name : "+department1.getDepartmentName()+"\n"+
                    "Department Employees : "+department1.getEmployees()+"\n"
                    ,HttpStatus.OK);
        }catch (NoSuchElementException e){
            logger.log(Level.WARNING,"This department was not found.");
            return new ResponseEntity<String>("This department was not found!\n" +
                    "Error is 404", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllDepartmentsDTO") // This method will find all departments from our database
    public List<DepartmentDTO> getAllDepartmentsDTO(){
        List<Department> departments;
        List<DepartmentDTO> departmentDTOS;
        try{
            departments = this.departmentService.findAllDepartments();
            departmentDTOS = departments.stream().map(u-> this.departmentMapper.convertToDepartmentDTO(u)).collect(Collectors.toList());
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Responded","getAllDepartmentsDTO");
            ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).body(departmentDTOS);
            logger.log(Level.INFO,"These departments are in our database.");
            return departmentDTOS;
        }catch (NoSuchElementException e){
            logger.log(Level.WARNING,"No departments were found.");
            throw new DepartmentNotFoundException(1);
        }
    }

}
