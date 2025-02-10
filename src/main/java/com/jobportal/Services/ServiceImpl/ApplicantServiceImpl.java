package com.jobportal.Services.ServiceImpl;

import com.jobportal.DTOS.ApplicantDTO;
import com.jobportal.DTOS.ProfileDTO;
import com.jobportal.Entities.Applicant;
import com.jobportal.Entities.Job;
import com.jobportal.Entities.User;
import com.jobportal.Repositories.ApplicantRepository;
import com.jobportal.Repositories.JobRepository;
import com.jobportal.Repositories.UserRepository;
import com.jobportal.Services.ApplicantService;
import com.jobportal.Utility.Application;
import com.jobportal.Utility.ApplicationStatus;
import com.jobportal.Utility.JobPortalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ApplicantServiceImpl implements ApplicantService {
    @Autowired
    private ApplicantRepository applicantRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<ApplicantDTO> getApplicants() {
        return applicantRepository.findAll().stream().map(Applicant::toDTO).toList();
    }

    @Override
    public ApplicantDTO getApplicant(Long id) {
        return applicantRepository.findById(id).orElseThrow(()->new JobPortalException("Applicant not found")).toDTO();
    }

    @Override
    public ApplicantDTO addApplicant(ApplicantDTO applicant,Long jobId, Long userId) {
        Job job = jobRepository.findById(jobId).orElseThrow(()->new JobPortalException("Job not found"));
        User user = userRepository.findById(userId).orElseThrow(()->new JobPortalException("User not found"));
        for (Applicant userApplicant : user.getApplicants()) {
            if(userApplicant.getJob()==job){
                throw new JobPortalException("Applicant already exists");
            }
        }
        applicant.setJob(job);
        applicant.setUser(user);
        applicant.setTimestamp(LocalDateTime.now());
        applicant.setApplicationStatus(ApplicationStatus.APPLIED);
        return applicantRepository.save(applicant.toApplicant()).toDTO();
    }

    @Override
    public List<ProfileDTO> getAllProfilesOfApplicantsOfJob(Long jobId) {
        Job job = jobRepository.findById(jobId).orElseThrow(()->new JobPortalException("Job not found"));
        List<Applicant> applicants = job.getApplicants();
        List<ProfileDTO> profiles = applicants.stream().map(ap -> {
            ProfileDTO dto = ap.getUser().getProfile().toDTO();
            dto.setApplicationStatus(ap.getApplicationStatus()); // Modify DTO
            return dto; // Return modified DTO
        }).toList();
        return profiles;
    }

    @Override
    public List<ApplicantDTO> getJobApplicants(Long jobId) {
        Job job = jobRepository.findById(jobId).orElseThrow(()->new JobPortalException("Job not found"));
        return applicantRepository.findApplicantsByJob(job).stream().map(Applicant::toDTO).toList();
    }

    @Override
    public ApplicantDTO updateApplicationStatus(Long applicantId, Application application) {
        Applicant applicant = applicantRepository.findById(applicantId).orElseThrow(()-> new JobPortalException("Applicant not found"));
        if(application.getApplicationStatus()!=null){
        applicant.setApplicationStatus(application.getApplicationStatus());
        }
        if(application.getInterviewDate()!=null){
            applicant.setInterviewDate(application.getInterviewDate());
        }
        if(application.getInterviewTime()!=null){
            applicant.setInterviewTime(application.getInterviewTime());
        }
        applicantRepository.save(applicant);
        return applicant.toDTO();
    }
}
