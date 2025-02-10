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

    @ManyToMany(mappedBy = "skills")
    @JsonIgnore
    private List<Job> jobs = new ArrayList<Job>();
    public Long getId() {
        return id;
    }

    @ManyToMany(mappedBy = "skills")
    @JsonIgnore
    private List<Profile> profiles= new ArrayList<>();

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

    public Skills(Long id, String skillName, List<Job> jobs, List<Profile> profiles) {
        this.id = id;
        this.skillName = skillName;
        this.jobs = jobs;
        this.profiles = profiles;
    }
    public Skills() {}

    public SkillsDTO toDTO() {
        return new SkillsDTO(id, skillName,jobs,profiles);
    }

}
