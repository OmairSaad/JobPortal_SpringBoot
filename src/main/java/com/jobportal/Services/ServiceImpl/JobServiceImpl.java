package com.jobportal.Services.ServiceImpl;

import com.jobportal.DTOS.JobDTO;
import com.jobportal.Entities.Applicant;
import com.jobportal.Entities.Job;
import com.jobportal.Entities.Skills;
import com.jobportal.Entities.User;
import com.jobportal.Repositories.JobRepository;
import com.jobportal.Repositories.SkillsRepository;
import com.jobportal.Repositories.UserRepository;
import com.jobportal.Services.JobService;
import com.jobportal.Utility.JobPortalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;
    private final UserRepository userRepository;
    private final SkillsRepository skillsRepository;
    public JobServiceImpl(JobRepository jobRepository, UserRepository userRepository, SkillsRepository skillsRepository) {
        this.jobRepository = jobRepository;
        this.userRepository = userRepository;
        this.skillsRepository = skillsRepository;
    }

    @Override
    public Job addJob(JobDTO job, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new JobPortalException("User not found"));
        job.setUser(user);
        System.out.println(job.toString());
        // Initialize skills list
        List<Skills> jobSkills = new ArrayList<>();

           List<Skills> skills = job.toJob().getSkills();
        // Process the list of skills from DTOs
        for (Skills sk: skills) {
            Skills skill = skillsRepository.findBySkillName(sk.getSkillName())
                    .orElseGet(() -> {
                        // If skill does not exist, create a new skill entity
                        Skills newSkill = new Skills();
                        newSkill.setSkillName(sk.getSkillName());
                        return skillsRepository.save(newSkill);
                    });

            // Add the job reference to the skill (bidirectional mapping)
            skill.getJobs().add(job.toJob());

            // Add skill to the job's skills list
            jobSkills.add(skill);
        }
        job.setSkills(jobSkills);
        job.setPostedAgo(LocalDateTime.now());
        return jobRepository.save(job.toJob());
    }

    @Override
    public List<JobDTO> getAllJobs() {
        return jobRepository.findAll().stream().map(Job::toDTO).toList();
    }

    @Override
    public List<JobDTO> getAllJobsByUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new JobPortalException("User not found"));
        return jobRepository.findByUser(user).stream().map(Job::toDTO).toList();
    }

    @Override
    public ResponseEntity<JobDTO> getJobById(Long id,Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new JobPortalException("User not found"));
        Job job = jobRepository.findById(id).orElseThrow(()-> new JobPortalException("Job not found"));
        List<Applicant> applicants = user.getApplicants();
        JobDTO jd = job.toDTO();
        if(user.getSavedJobs().contains(job)){
            jd.setSaved(true);
        }
        Optional<Applicant> appOp = applicants.stream().filter((ap)-> ap.getJob().equals(job)).findFirst();
        if(appOp.isPresent()) {
            jd.setApplicationStatus(appOp.get().getApplicationStatus());
            jd.setApplicantTimestamp(appOp.get().getTimestamp());
        }
        return new ResponseEntity<>(jd, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> toggleSaveJob(Long jobId,Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new JobPortalException("User not found id"));
        Job job= jobRepository.findById(jobId).orElseThrow(()->new JobPortalException("Job not found"));
        if(user.getSavedJobs().contains(job)) {
            //unsaved
            user.getSavedJobs().remove(job);
            userRepository.save(user);
            return new ResponseEntity<>("Job Unsaved", HttpStatus.OK);
        }else{
            user.getSavedJobs().add(job);
            userRepository.save(user);
            return new ResponseEntity<>("Job Saved", HttpStatus.OK);
        }
    }

    @Override
    public List<JobDTO> getAllSavedJobs(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new JobPortalException("User not found"));
        return user.getSavedJobs().stream().map(Job::toDTO).toList();
    }

    @Override
    public List<JobDTO> getAllJobsWithSaved(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(()-> new JobPortalException("User not found"));
        List<Job> jobs = jobRepository.findAll();
        List<Job> savedJobs = user.getSavedJobs();
        List<Applicant> applicants = user.getApplicants();
        List<JobDTO> jobDTOs = new ArrayList<>();
        for (Job job: jobs) {
            JobDTO jd = job.toDTO();
            if(savedJobs.contains(job)) {
                jd.setSaved(true);
            }
            Optional<Applicant> appOp = applicants.stream().filter((ap)-> ap.getJob().equals(job)).findFirst();
            if(appOp.isPresent()) {
                jd.setApplicationStatus(appOp.get().getApplicationStatus());
                jd.setApplicantTimestamp(appOp.get().getTimestamp());
            }
            jobDTOs.add(jd);
        }
        return jobDTOs;
    }
}
