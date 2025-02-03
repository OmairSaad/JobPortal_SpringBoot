package com.jobportal.Controllers;

import com.jobportal.DTOS.JobDTO;
import com.jobportal.Entities.Job;
import com.jobportal.Services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "http://localhost:5173")
public class JobController {
    @Autowired
    private JobService jobService;
    @PostMapping("/user/{userId}")
    public ResponseEntity<JobDTO> addJob(@RequestBody JobDTO job, @PathVariable Long userId) {
        return new ResponseEntity<JobDTO>(jobService.addJob(job,userId).toDTO(), HttpStatus.CREATED);
    }
     @GetMapping("")
    public List<JobDTO> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/user/{userId}")
    public List<JobDTO> getJobsByUserId(@PathVariable Long userId) {
        return jobService.getAllJobsByUser(userId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }
}
