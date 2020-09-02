package com.employee.Service;

import com.employee.Model.DAO.Department;
import com.employee.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // Here, I created methods for update, delete, get and getAll. These methods will aid me to manipulate data better.
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department){
        return this.departmentRepository.save(department);
    }

    public Department updateDepartment(Department department, int id){

        Department department2 = this.departmentRepository.findById(id).get();

        if(department2 != null){
            department.setDepartmentId(id);
            return this.departmentRepository.save(department);
        }else{
            throw new RuntimeException("Department was not found!");
        }
    }

    public void deleteDepartmentById(int id){
        this.departmentRepository.deleteById(id);
    }

    public Department findDepartmentById(int id){
        return this.departmentRepository.findById(id).get();
    }

    public List<Department> findAllDepartments(){
        return this.departmentRepository.findAll();
    }

    public List<Department> orderByDepartmentName(){
        return this.departmentRepository.OrderByDepartmentName();
    }

    public Department findByWhereMethod(int id){
        return this.departmentRepository.FindByWhereMethod(id);
    }

}
