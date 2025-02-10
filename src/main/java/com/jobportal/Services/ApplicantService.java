package com.jobportal.Services;

import com.jobportal.DTOS.ApplicantDTO;
import com.jobportal.DTOS.ProfileDTO;
import com.jobportal.Utility.Application;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApplicantService {
    List<ApplicantDTO> getApplicants();
    ApplicantDTO getApplicant(Long id);
    ApplicantDTO addApplicant(ApplicantDTO applicant,Long jobId,Long userId);
    List<ProfileDTO> getAllProfilesOfApplicantsOfJob(Long jobId);
    List<ApplicantDTO> getJobApplicants(Long jobId);
    ApplicantDTO updateApplicationStatus(Long applicantId, Application application);
}
