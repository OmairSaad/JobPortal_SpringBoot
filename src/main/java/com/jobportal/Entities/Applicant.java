package com.jobportal.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jobportal.DTOS.ApplicantDTO;
import com.jobportal.Utility.ApplicationStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Base64;

@Entity
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Lob
    private byte[] resume;
    @ManyToOne()
    @JsonIgnore
    private Job job;
    @ManyToOne()
    @JsonIgnore
    private User user;

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

    public byte[] getResume() {
        return resume;
    }

    public void setResume(byte[] resume) {
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

    public Applicant(Long applicantId, LocalDateTime timestamp, ApplicationStatus applicationStatus, String name, String email, String phone, String website, String cover, byte[] resume, Job job, User user, LocalDateTime interviewDate, String interviewTime) {
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
        this.interviewDate = interviewDate;
        this.interviewTime = interviewTime;
    }
    public Applicant() {}

    public ApplicantDTO toDTO(){
        return new ApplicantDTO(applicantId,timestamp,applicationStatus,name,email,phone,website,cover,resume!=null? Base64.getEncoder().encodeToString(resume):null,job,user, user!=null? user.getProfile().toDTO() : null, interviewDate, interviewTime);
    }
}
