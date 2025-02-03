package com.jobportal.DTOS;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobportal.Entities.Job;
import com.jobportal.Entities.Profile;
import com.jobportal.Entities.Skills;

import java.util.ArrayList;
import java.util.List;

public class SkillsDTO {
    private Long id;
    private String skillName;
    @JsonIgnore
    private Profile profile;
    private List<Job> jobs = new ArrayList<Job>();
    public SkillsDTO(Long id, String skillName, Profile profile, List<Job> jobs) {
        this.id = id;
        this.skillName = skillName;
        this.profile = profile;
        this.jobs = jobs;
    }

    public Skills toSkills() {
        return new Skills(id,skillName,profile, jobs);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public SkillsDTO() {
    }
}
