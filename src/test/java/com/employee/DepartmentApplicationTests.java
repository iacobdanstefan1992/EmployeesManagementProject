package com.employee;

import com.employee.Model.DAO.Department;
import com.employee.Repository.DepartmentRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DepartmentApplicationTests { // This test will check if the data is correct

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    void savedDepartmentHasRegistration() {
        Department department = new Department(1,"IT");
        Optional<Department> department2 = departmentRepository.findById(department.getDepartmentId());
        Assert.assertEquals(department,department2);
    }

}
