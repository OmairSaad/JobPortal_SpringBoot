package com.jobportal.Services.ServiceImpl;

import com.jobportal.DTOS.ProfileSkillDTO;
import com.jobportal.DTOS.SkillsDTO;
import com.jobportal.Entities.Profile;
import com.jobportal.Entities.ProfileSkill;
import com.jobportal.Entities.Skills;
import com.jobportal.Repositories.ProfileRepository;
import com.jobportal.Repositories.ProfileSkillRepository;
import com.jobportal.Repositories.SkillsRepository;
import com.jobportal.Services.SkillsService;
import com.jobportal.Utility.JobPortalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillsServiceImpl implements SkillsService {
    @Autowired
    private SkillsRepository skillsRepository;

    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private ProfileSkillRepository profileSkillRepository;

    public List<ProfileSkillDTO> createSkills(List<ProfileSkillDTO> skills, Long id) {
        Profile profile = profileRepository.findById(id).orElseThrow(()-> new JobPortalException("Profile not found"));
        List<ProfileSkill> skillsList = new ArrayList<>();
        for (ProfileSkillDTO skill : skills) {
             skill.setProfile(profile);
             skillsList.add(skill.toProfileSkill());
        }
        List<ProfileSkill> sk =profileSkillRepository.getSkillsByProfile(profile);
        profileSkillRepository.deleteAll(sk);
        return profileSkillRepository.saveAll(skillsList).stream().map((ProfileSkill::toDTO)).collect(Collectors.toList());
    }

    @Override
    public List<ProfileSkillDTO> getAllSkills() {
        return profileSkillRepository.findAll().stream().map((ProfileSkill::toDTO)).collect(Collectors.toList());
    }

    @Override
    public Skills getSkillById(Long id) {
        return skillsRepository.findById(id).orElseThrow(()-> new JobPortalException("Skill id not found"));
    }
}
