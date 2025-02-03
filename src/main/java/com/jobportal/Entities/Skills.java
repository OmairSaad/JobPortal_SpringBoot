package com.jobportal.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jobportal.DTOS.SkillsDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String skillName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Profile profile;

    @ManyToMany(mappedBy = "skills")
    @JsonIgnore
    private List<Job> jobs = new ArrayList<Job>();
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

    public Skills(Long id, String skillName, Profile profile, List<Job> jobs) {
        this.id = id;
        this.skillName = skillName;
        this.profile = profile;
        this.jobs = jobs;
    }
    public Skills() {}

    public SkillsDTO toDTO() {
        return new SkillsDTO(id, skillName, profile,jobs);
    }

}
