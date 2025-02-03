package com.jobportal.Services.ServiceImpl;

import com.jobportal.DTOS.ExperienceDTO;
import com.jobportal.Entities.Exprience;
import com.jobportal.Entities.Profile;
import com.jobportal.Repositories.ExperienceRepository;
import com.jobportal.Repositories.ProfileRepository;
import com.jobportal.Services.ExprienceService;
import com.jobportal.Utility.JobPortalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExprienceServiceImpl implements ExprienceService {
    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public List<Exprience> getAllExprience() {
        return experienceRepository.findAll();
    }

    @Override
    public ExperienceDTO addExprience(ExperienceDTO exprience, Long id) {
        Profile profile = profileRepository.findById(id).orElseThrow(()-> new JobPortalException("Profile not found"));
        Exprience ex = exprience.toExperience();
        ex.setProfile(profile);
        return experienceRepository.save(ex).toExprienceDTO();
    }

    @Override
    public ExperienceDTO updateExprience(ExperienceDTO exprience, Long id) {
        Profile profile = profileRepository.findById(id).orElseThrow(()-> new JobPortalException("Profile not found"));
        exprience.setProfile(profile);
        return experienceRepository.save(exprience.toExperience()).toExprienceDTO();
    }

    @Override
    public ResponseEntity<String> delExp(Long expId) {
        Exprience exp = experienceRepository.findById(expId).orElseThrow(()-> new JobPortalException("Experience not found"));
        experienceRepository.delete(exp);
        return new ResponseEntity<String>("Exp deleted id: "+expId, HttpStatus.OK);
    }
}
