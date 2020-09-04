package com.employee.Controller;

import com.employee.Exception.ExceptionEmployee.JobCategoryNameException;
import com.employee.Exception.ExceptionEmployee.JobCategoryNotFoundException;
import com.employee.Mapper.JobCategoryMapper;
import com.employee.Model.DAO.JobCategory;
import com.employee.Model.DTO.JobCategoryDTO;
import com.employee.Service.JobCategoryService;
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
@RequestMapping("/job_categories")
@CrossOrigin(origins = "*")
public class JobCategoryController {

    @Autowired
    private JobCategoryService jobCategoryService;

    @Autowired
    private JobCategoryMapper jobCategoryMapper;

    private static final Logger logger = Logger.getLogger(JobCategoryController.class.getName());

    @PostMapping("/addJobCategory") // This method will add a new jobCategory in our database
    public JobCategory saveJobCategory(@RequestBody JobCategory jobCategory){
        JobCategory jobCategory1;
        JobCategory jobCategory2;
        try{
            jobCategory1 = jobCategoryService.findByWhereMethod(jobCategory.getJobCategoryId());
            if(jobCategory1 != null ){
                logger.log(Level.WARNING,"This jobCategory is in our database.");
                throw new JobCategoryNotFoundException(jobCategory.getJobCategoryId());
            }else if(jobCategory.getJobCategoryName().isEmpty()){
                logger.log(Level.WARNING,"One of the fields is empty.");
                throw new JobCategoryNotFoundException(jobCategory.getJobCategoryId());
            }else{
                logger.log(Level.INFO,"A new jobCategory was added.");
                jobCategory2 = this.jobCategoryService.saveJobCategory(jobCategory);
            }
        }catch (NoSuchElementException e){
            logger.log(Level.SEVERE,"Exception error : " + e);
            throw new JobCategoryNotFoundException(jobCategory.getJobCategoryId());
        }finally {
            logger.log(Level.INFO,"Method:addJobCategory");
        }
        return jobCategory2;
    }

    @PutMapping("/updateJobCategory/{id_jobCategory}") // This method will update a jobCategory from our database
    public JobCategory jobCategory(@RequestBody JobCategory jobCategory, @PathVariable int id_jobCategory){
        JobCategory jobCategory1;
        JobCategory jobCategory2;
        try{
            jobCategory1 = jobCategoryService.findJobCategoryById(jobCategory.getJobCategoryId());
            if(jobCategory1 == null){
                logger.log(Level.WARNING,"This jobCategory is not in our database.");
                throw new JobCategoryNotFoundException(jobCategory.getJobCategoryId());
            }else{
                logger.log(Level.INFO,"A new jobCategory was updated.");
                jobCategory2 = this.jobCategoryService.updateJobCategory(jobCategory, id_jobCategory);
            }
        }catch (NoSuchElementException e){
            logger.log(Level.SEVERE,"Exception error : " + e);
            throw new JobCategoryNotFoundException(jobCategory.getJobCategoryId());
        }
        return jobCategory2;
    }

    @DeleteMapping("/deleteJobCategory/{id}") // This method will delete a jobCategory from our database
    public void deleteJobCategory(@PathVariable int id){
        JobCategory jobCategory;
        try{
            jobCategory = jobCategoryService.findJobCategoryById(id);
            if(jobCategory == null){
                logger.log(Level.WARNING,"This jobCategory is not in our database.");
                throw new JobCategoryNotFoundException(id);
            }else{
                logger.log(Level.INFO,"A jobCategory was deleted.");
                this.jobCategoryService.deleteJobCategoryById(id);
            }
        }catch (NoSuchElementException e){
            logger.log(Level.SEVERE,"Exception error : " + e);
            throw new JobCategoryNotFoundException(id);
        }
    }

    @GetMapping("/getJobCategoryById/{id}") // This method will get a jobCategory from our database
    public JobCategory findJobCategoryById(@PathVariable int id) throws IOException{
        JobCategory jobCategory;
        JobCategory jobCategory1;
        try{
            jobCategory1 = jobCategoryService.findByWhereMethod(id);
            if(jobCategory1 == null){
                logger.log(Level.WARNING,"This jobCategory is not in our database.");
                throw new JobCategoryNotFoundException(id);
            }else{
                logger.log(Level.INFO,"A jobCategory was found.");
                jobCategory = this.jobCategoryService.findJobCategoryById(id);
            }
        }catch (NoSuchElementException e){
            logger.log(Level.SEVERE,"Exception error : " + e);
            throw new JobCategoryNotFoundException(id);
        }
        return jobCategory;
    }

    @GetMapping("/getAllJobCategories") // This method will get all jobCategories from our database
    public List<JobCategory> findAllJobCategories(){
        List<JobCategory> jobCategories;
        JobCategory jobCategory;
        try{
            jobCategory = jobCategoryService.findByWhereMethod(1);
            if(jobCategory == null){
                logger.log(Level.WARNING,"No jobCategories were found in our database.");
                throw new JobCategoryNotFoundException(1);
            }else{
                logger.log(Level.INFO,"jobCategories were found.");
                jobCategories = this.jobCategoryService.findAllJobCategories();
                return jobCategories;
            }
        }catch (NoSuchElementException e){
            logger.log(Level.WARNING,"No jobCategories were found in our database.");
            throw new JobCategoryNotFoundException(1);
        }
    }

    @GetMapping("/orderByJobCategoryName") // This method will sort all jobCategories by first name from our database
    public ResponseEntity<List<JobCategory>> OrderByJobCategoryName(){
        List<JobCategory> jobCategories;
        try{
            logger.log(Level.INFO,"These jobCategories are in our database.");
            jobCategories = this.jobCategoryService.orderByJobCategoryName();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Responded","orderByJobCategoryName");
            return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).body(jobCategories);
        }catch (NoSuchElementException e){
            logger.log(Level.WARNING,"These jobCategories were not found.");
            throw new JobCategoryNameException("default");
        }
    }

    @GetMapping("/findByWhereMethod/{id}") // This method will find a jobCategory from our database
    public ResponseEntity<JobCategory> findByWhereMethod(@PathVariable int id){
        JobCategory jobCategory;
        try{
            logger.log(Level.INFO,"This jobCategory is in our database.");
            jobCategory = this.jobCategoryService.findByWhereMethod(id);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Responded","findByWhereMethod");
            return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).body(jobCategory);
        }catch (NoSuchElementException e){
            logger.log(Level.WARNING,"This jobCategory was not found.");
            throw new JobCategoryNotFoundException(id);
        }
    }

    @GetMapping("/getJobCategoryDtoById/{id}") // This method will find a jobCategory by id from our database
    public ResponseEntity<String> getJobCategoryDtoById(@PathVariable int id){
        JobCategory jobCategory;
        JobCategoryDTO jobCategoryDTO;
        try{
            jobCategory = this.jobCategoryService.findJobCategoryById(id);
            jobCategoryDTO = this.jobCategoryMapper.convertToJobCategoryDTO(jobCategory);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Responded","getJobCategoryDtoById");
            ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).body(jobCategoryDTO);
            logger.log(Level.INFO,"This jobCategory is in our database.");
            return new ResponseEntity<String>("This jobCategory was found! \n" +
                    "JobCategory Name : "+jobCategoryDTO.getName()+"\n"+
                    "JobCategory Employees : "+jobCategoryDTO.getEmployees()+"\n"
                    ,HttpStatus.OK);
        }catch (NoSuchElementException e){
            logger.log(Level.WARNING,"This jobCategory was not found.");
            return new ResponseEntity<String>("This jobCategory was not found!\n" +
                    "Error is 404", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllJobCategoriesDTO") // This method will find all jobCategories from our database
    public List<JobCategoryDTO> getAllJobCategoriesDTO(){
        List<JobCategory> jobCategories;
        List<JobCategoryDTO> jobCategoryDTOS;
        try{
            jobCategories = this.jobCategoryService.findAllJobCategories();
            jobCategoryDTOS = jobCategories.stream().map(u-> this.jobCategoryMapper.convertToJobCategoryDTO(u)).collect(Collectors.toList());
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Responded","getAllJobCategoriesDTO");
            ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).body(jobCategoryDTOS);
            logger.log(Level.INFO,"These jobCategories are in our database.");
            return jobCategoryDTOS;
        }catch (NoSuchElementException e){
            logger.log(Level.WARNING,"No jobCategories were found.");
            throw new JobCategoryNotFoundException(1);
        }
    }

}
