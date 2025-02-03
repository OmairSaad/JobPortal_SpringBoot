package com.jobportal.Services;

import com.jobportal.DTOS.ExperienceDTO;
import com.jobportal.Entities.Exprience;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExprienceService {
     List<Exprience> getAllExprience();
     ExperienceDTO addExprience(ExperienceDTO exprience, Long id);
     ExperienceDTO updateExprience(ExperienceDTO exprience, Long id);
     ResponseEntity<String> delExp(Long expId);


}
