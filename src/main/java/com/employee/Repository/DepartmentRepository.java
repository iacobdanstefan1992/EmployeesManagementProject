package com.employee.Repository;

import com.employee.Model.DAO.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository // This repository gives us methods to use at manipulating data, for instance, methods like delete, update or get some information
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    @Override
    List<Department> findAll();

    @Override
    Optional<Department> findById(Integer integer);

    @Query(value = "SELECT * FROM Departments ORDER BY department_name ASC",
            nativeQuery = true)
    List<Department> OrderByDepartmentName();

    @Query(value = "SELECT * FROM Departments WHERE department_id = :id ORDER BY department_name DESC",
            nativeQuery = true)
    Department FindByWhereMethod(@Param("id") int id);
}
