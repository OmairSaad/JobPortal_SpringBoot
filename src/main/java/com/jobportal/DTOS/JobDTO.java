package com.jobportal.DTOS;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobportal.Entities.Applicant;
import com.jobportal.Entities.Job;
import com.jobportal.Entities.Skills;
import com.jobportal.Entities.User;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JobDTO {
    private Long id;
    private String jobTitle;
    private String company;
    private String experience;
    private String location;
    private String jobType;
    private Long salary;
    private LocalDateTime postedAgo;
    private String about;
    private String jobDescription;
    @JsonIgnore
    private User user;
    private List<Skills> skills = new ArrayList<>();
    private List<Applicant> applicants = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public LocalDateTime getPostedAgo() {
        return postedAgo;
    }

    public void setPostedAgo(LocalDateTime postedAgo) {
        this.postedAgo = postedAgo;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    public List<Applicant> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<Applicant> applicants) {
        this.applicants = applicants;
    }

    public JobDTO(Long id, String jobTitle, String company, String experience, String location, String jobType, Long salary, LocalDateTime postedAgo, String about, String jobDescription, User user, List<Skills> skills, List<Applicant> applicants) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.company = company;
        this.experience = experience;
        this.location = location;
        this.jobType = jobType;
        this.salary = salary;
        this.postedAgo = postedAgo;
        this.about = about;
        this.jobDescription = jobDescription;
        this.user = user;
        this.skills = skills;
        this.applicants = applicants;
    }
    public Job toJob() {
        return new Job(id,jobTitle,company,experience,location,jobType,salary, postedAgo, about,jobDescription,user,skills,applicants);
    }
}
