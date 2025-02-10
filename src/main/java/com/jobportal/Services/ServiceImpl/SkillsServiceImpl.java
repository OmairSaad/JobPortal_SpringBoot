package com.jobportal.Services.ServiceImpl;

import com.jobportal.DTOS.ProfileDTO;
import com.jobportal.DTOS.ProfileSkillDTO;
import com.jobportal.DTOS.SkillsDTO;
import com.jobportal.Entities.Profile;
import com.jobportal.Entities.ProfileSkill;
import com.jobportal.Entities.Skills;
import com.jobportal.Entities.User;
import com.jobportal.Repositories.ProfileRepository;
import com.jobportal.Repositories.ProfileSkillRepository;
import com.jobportal.Repositories.SkillsRepository;
import com.jobportal.Services.SkillsService;
import com.jobportal.Utility.JobPortalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public ProfileDTO createSkills(List<SkillsDTO> skills, Long id) {
        Profile profile = profileRepository.findById(id).orElseThrow(()-> new JobPortalException("Profile not found"));

        profile.getSkills().clear();
        profileRepository.save(profile); // Ensure old relationships are removed

        // Initialize skills list
        List<Skills> profileSkills = new ArrayList<>();

        // Process the list of skills from DTOs
        for (SkillsDTO sk : skills) {
            Skills skill = skillsRepository.findBySkillName(sk.getSkillName())
                    .orElseGet(() -> {
                        // If skill does not exist, create a new skill entity
                        Skills newSkill = new Skills();
                        newSkill.setSkillName(sk.getSkillName());
                        return skillsRepository.save(newSkill);
                    });

            // Add skill to the job's skills list
            profileSkills.add(skill);
        }
        profile.setSkills(profileSkills);
       return profileRepository.save(profile).toDTO();
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
