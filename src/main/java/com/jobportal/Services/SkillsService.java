package com.jobportal.Services;

import com.jobportal.DTOS.ProfileSkillDTO;
import com.jobportal.DTOS.SkillsDTO;
import com.jobportal.Entities.Skills;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SkillsService {
    public List<ProfileSkillDTO> createSkills(List<ProfileSkillDTO> skills, Long id);
    public List<ProfileSkillDTO> getAllSkills();
    public Skills getSkillById(Long id);
}
