package com.employee.Service;

import com.employee.Model.DAO.JobCategory;
import com.employee.Repository.JobCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // Here, I created methods for update, delete, get and getAll. These methods will aid me to manipulate data better.
public class JobCategoryService {

    @Autowired
    private JobCategoryRepository jobCategoryRepository;

    public JobCategory saveJobCategory(JobCategory jobCategory){
        return this.jobCategoryRepository.save(jobCategory);
    }

    public JobCategory updateJobCategory(JobCategory jobCategory, int id){

        JobCategory jobCategory2 = this.jobCategoryRepository.findById(id).get();

        if(jobCategory2 != null){
            jobCategory.setJobCategoryId(id);
            return this.jobCategoryRepository.save(jobCategory);
        }else{
            throw new RuntimeException("JobCategory was not found!");
        }

    }

    public void deleteJobCategoryById(int id){
        this.jobCategoryRepository.deleteById(id);
    }

    public JobCategory findJobCategoryById(int id){
        return this.jobCategoryRepository.findById(id).get();
    }

    public List<JobCategory> findAllJobCategories(){
        return this.jobCategoryRepository.findAll();
    }

    public List<JobCategory> orderByJobCategoryName(){
        return this.jobCategoryRepository.OrderByJobCategoryName();
    }

    public JobCategory findByWhereMethod(int id){
        return this.jobCategoryRepository.FindByWhereMethod(id);
    }

}
