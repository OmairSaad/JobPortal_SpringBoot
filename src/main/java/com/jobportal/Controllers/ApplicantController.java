package com.jobportal.Controllers;

import com.jobportal.DTOS.ApplicantDTO;
import com.jobportal.DTOS.ProfileDTO;
import com.jobportal.Entities.Profile;
import com.jobportal.Services.ApplicantService;
import com.jobportal.Utility.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "http://localhost:5173")
public class ApplicantController {
    @Autowired
    private ApplicantService applicantService;
    @PostMapping("/{jobId}/user/{userId}")
    public ApplicantDTO s(@PathVariable Long jobId, @PathVariable Long userId,@RequestBody ApplicantDTO applicantDTO) {
        return applicantService.addApplicant(applicantDTO, jobId, userId);
    }

    @GetMapping("/allApplicants")
    public List<ApplicantDTO> getAllApplicants() {
        return applicantService.getApplicants();
    }

    @GetMapping("/{jobId}/applicant-profiles")
    public List<ProfileDTO> getAllProfilesOfApplicantsOfJob(@PathVariable Long jobId) {
        return applicantService.getAllProfilesOfApplicantsOfJob(jobId);
    }

    @GetMapping("{jobId}/applicants")
    public List<ApplicantDTO> getAllApplicantsOfJob(@PathVariable Long jobId) {
        return applicantService.getJobApplicants(jobId);
    }

    @PostMapping("/applicants/{applicantId}/update-status")
    public ApplicantDTO updateApplicationStatus(@PathVariable Long applicantId, @RequestBody Application application) {
        return  applicantService.updateApplicationStatus(applicantId,application);
    }

}
