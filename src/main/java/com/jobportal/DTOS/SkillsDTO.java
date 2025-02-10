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
    private List<Job> jobs = new ArrayList<Job>();
    private List<Profile> profiles= new ArrayList<>();

    public SkillsDTO(Long id, String skillName, List<Job> jobs, List<Profile> profiles) {
        this.id = id;
        this.skillName = skillName;
        this.jobs = jobs;
        this.profiles = profiles;
    }

    public Skills toSkills() {
        return new Skills(id,skillName, jobs, profiles);
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

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public SkillsDTO() {
    }
}
