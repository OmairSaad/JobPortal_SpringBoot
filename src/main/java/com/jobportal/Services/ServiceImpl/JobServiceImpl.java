package com.jobportal.Services.ServiceImpl;

import com.jobportal.DTOS.JobDTO;
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
    public ResponseEntity<JobDTO> getJobById(Long id) {
        return new ResponseEntity<>(jobRepository.findById(id).orElseThrow(()->new JobPortalException("Job not found!")).toDTO(), HttpStatus.OK);
    }
}
