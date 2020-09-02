package com.employee.Repository;

import com.employee.Model.DAO.JobCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository // This repository gives us methods to use at manipulating data, for instance, methods like delete, update or get some information
public interface JobCategoryRepository extends JpaRepository<JobCategory,Integer> {
    @Override
    List<JobCategory> findAll();

    @Override
    Optional<JobCategory> findById(Integer integer);

    @Query(value = "SELECT * FROM job_category ORDER BY job_category_name ASC",
            nativeQuery = true)
    List<JobCategory> OrderByJobCategoryName();

    @Query(value = "SELECT * FROM job_category WHERE job_category_id = :id ORDER BY job_category_name DESC",
            nativeQuery = true)
    JobCategory FindByWhereMethod(@Param("id") int id);
}
