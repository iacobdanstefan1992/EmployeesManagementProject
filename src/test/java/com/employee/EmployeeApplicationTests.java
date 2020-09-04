package com.employee;

import com.employee.Model.DAO.Employee;
import com.employee.Repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
@ExtendWith(SpringExtension.class)
@SpringBootTest
class EmployeeApplicationTests { // This test will check if the data is correct

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	void savedEmployeeHasRegistration() {
		Employee employee = new Employee(2,"Iacob","Dan");
		Optional<Employee> employee2 = employeeRepository.findByFirstName(employee.getFirstName());
		Assert.assertEquals(employee,employee2);
	}

}
