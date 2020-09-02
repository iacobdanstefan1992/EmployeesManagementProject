package com.employee.Repository;

import com.employee.Model.DAO.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository // This repository gives us methods to use at manipulating data, for instance, methods like delete, update or get some information
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Override
    List<Employee> findAll();

    @Override
    Optional<Employee> findById(Integer integer);

    Optional<Employee> findByFirstName(String firstName);

    @Query(value = "SELECT * FROM Employee ORDER BY first_name ASC, salary ASC",
            nativeQuery = true)
    List<Employee> OrderByFirstName();

    @Query(value = "SELECT * FROM Employee WHERE id = :id",
            nativeQuery = true)
    Employee FindByWhereMethod(@Param("id") int id);


}
