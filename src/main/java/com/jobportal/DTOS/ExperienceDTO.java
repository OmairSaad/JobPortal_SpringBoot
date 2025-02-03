package com.jobportal.DTOS;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobportal.Entities.Exprience;
import com.jobportal.Entities.Profile;

import java.time.LocalDate;

public class ExperienceDTO {

    private Long id;
    private String role;
    private String company;
    private String location;
    private LocalDate joinDate;
    private LocalDate endDate;
    private String des;
    @JsonIgnore
    private Profile profile;

    public ExperienceDTO(Long id, String role, String company, String location, LocalDate joinDate, LocalDate endDate, String des, Profile profile) {
        this.id = id;
        this.role = role;
        this.company = company;
        this.location = location;
        this.joinDate = joinDate;
        this.endDate = endDate;
        this.des = des;
        this.profile = profile;
    }
    public Exprience toExperience() {
       return new Exprience(id, role, company, location, joinDate, endDate, des, profile);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public ExperienceDTO() {
    }
}
