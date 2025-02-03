package com.jobportal.Controllers;


import com.jobportal.DTOS.ProfileSkillDTO;
import com.jobportal.DTOS.SkillsDTO;
import com.jobportal.Entities.Profile;
import com.jobportal.Entities.Skills;
import com.jobportal.Repositories.ProfileRepository;
import com.jobportal.Repositories.SkillsRepository;
import com.jobportal.Services.SkillsService;

import com.jobportal.Utility.JobPortalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin(origins = "http://localhost:5173")
public class SkillsController {
    @Autowired
    private SkillsService skillsService;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private SkillsRepository skillsRepository;

    @GetMapping("")
    public List<ProfileSkillDTO> getAllSkills() {
        return skillsService.getAllSkills();
    }
    @PostMapping("/{id}")
    public List<ProfileSkillDTO> addSkills(@RequestBody List<ProfileSkillDTO> skills, @PathVariable Long id) {
        return skillsService.createSkills(skills,id);
    }
}
