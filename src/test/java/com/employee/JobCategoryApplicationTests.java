package com.employee;

import com.employee.Model.DAO.JobCategory;
import com.employee.Repository.JobCategoryRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class JobCategoryApplicationTests { // This test will check if the data is correct

    @Autowired
    private JobCategoryRepository jobCategoryRepository;

    @Test
    void savedJobCategoryHasRegistration() {
        JobCategory jobCategory = new JobCategory(1,"Software Engineer");
        Optional<JobCategory> jobCategory2 = jobCategoryRepository.findById(jobCategory.getJobCategoryId());
        Assert.assertEquals(jobCategory,jobCategory2);
    }

}
