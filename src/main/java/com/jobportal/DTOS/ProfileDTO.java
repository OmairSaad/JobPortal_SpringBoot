package com.jobportal.DTOS;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jobportal.Entities.*;
import com.jobportal.Utility.ApplicationStatus;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class ProfileDTO {
    private Long id;
    private String email;
    private String name;
    private String role;
    private String location;
    @Column(name="about",length = 2000)
    private String about;
    private String company;
    private String picture;
    @JsonIgnore
    private User user;
//    private List<ProfileSkill> skills = new ArrayList<>();
    private List<Skills> skills = new ArrayList<>();

    private List<Exprience> expriences = new ArrayList<>();
    private List<Certifications> certifications = new ArrayList<>();

    //application status for showing on profile in applicants interviewed or not
    private ApplicationStatus applicationStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public List<Exprience> getExpriences() {
        return expriences;
    }

    public void setExpriences(List<Exprience> expriences) {
        this.expriences = expriences;
    }

    public List<Certifications> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<Certifications> certifications) {
        this.certifications = certifications;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public ProfileDTO(Long id, String email, String name, String role, String location, String about, String picture, String company, User user, List<Skills> skills, List<Exprience> expriences, List<Certifications> certifications, ApplicationStatus applicationStatus) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.role = role;
        this.location = location;
        this.about = about;
        this.picture = picture;
        this.company = company;
        this.user = user;
        this.skills = skills;
        this.expriences = expriences;
        this.certifications = certifications;
        this.applicationStatus = applicationStatus;
    }
    public ProfileDTO() {}
    public Profile toProfile(){
        return new Profile(id, email, name, role, location, about, this.picture!=null? Base64.getDecoder().decode(this.picture):null, company, user,skills,  expriences, certifications);
    }

}
