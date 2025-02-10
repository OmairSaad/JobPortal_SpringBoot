package com.jobportal.Services;

import com.jobportal.DTOS.ProfileDTO;
import com.jobportal.DTOS.ProfileSkillDTO;
import com.jobportal.DTOS.SkillsDTO;
import com.jobportal.Entities.Skills;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SkillsService {
    public ProfileDTO createSkills(List<SkillsDTO> skills, Long id);
    public List<ProfileSkillDTO> getAllSkills();
    public Skills getSkillById(Long id);
}
