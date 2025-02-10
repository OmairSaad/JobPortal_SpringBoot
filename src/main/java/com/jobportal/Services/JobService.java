package com.jobportal.Services;

import com.jobportal.DTOS.JobDTO;
import com.jobportal.Entities.Job;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface JobService {
    Job addJob(JobDTO job, Long userId);
    List<JobDTO> getAllJobs();
    List<JobDTO> getAllJobsByUser(Long userId);
    ResponseEntity<JobDTO> getJobById(Long id, Long userId);
    ResponseEntity<String> toggleSaveJob(Long jobId,Long userId);
    List<JobDTO> getAllSavedJobs(Long userId);
    List<JobDTO> getAllJobsWithSaved(Long userId);
}
