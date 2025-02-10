package com.jobportal.DTOS;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jobportal.Entities.Applicant;
import com.jobportal.Entities.Job;
import com.jobportal.Entities.User;
import com.jobportal.Utility.ApplicationStatus;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.Base64;

public class ApplicantDTO {
    private  Long applicantId;
    private LocalDateTime timestamp;
    private ApplicationStatus applicationStatus;
    private LocalDateTime interviewDate;
    private String interviewTime;
    private String name;
    private String email;
    private String phone;
    private String website;
    private String cover;
    private String resume;
    @JsonIgnore
    private Job job;
    @JsonIgnore
    private User user;

    private ProfileDTO profile;

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ProfileDTO getProfile() {
        return profile;
    }

    public void setProfile(ProfileDTO profile) {
        this.profile = profile;
    }

    public LocalDateTime getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(LocalDateTime interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(String interviewTime) {
        this.interviewTime = interviewTime;
    }

    public ApplicantDTO(Long applicantId, LocalDateTime timestamp, ApplicationStatus applicationStatus, String name, String email, String phone, String website, String cover, String resume, Job job, User user, ProfileDTO profile, LocalDateTime interviewDate, String interviewTime) {
        this.applicantId = applicantId;
        this.timestamp = timestamp;
        this.applicationStatus = applicationStatus;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.cover = cover;
        this.resume = resume;
        this.job = job;
        this.user = user;
        this.profile = profile;
        this.interviewDate = interviewDate;
        this.interviewTime = interviewTime;
    }

    public Applicant toApplicant(){
        return new Applicant(applicantId,timestamp,applicationStatus,name,email,phone,website,cover,resume!=null ? Base64.getDecoder().decode(resume):null,job,user, interviewDate,interviewTime);
    }
}
