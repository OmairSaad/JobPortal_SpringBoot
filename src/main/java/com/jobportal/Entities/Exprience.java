package com.jobportal.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobportal.DTOS.ExperienceDTO;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Exprience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;
    private String company;
    private String location;
    private LocalDate joinDate;
    @Column(nullable = true)
    private LocalDate endDate;
    private String des;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Profile profile;

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

    public void setDes(String desc) {
        this.des= desc;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Exprience(Long id, String role, String company, String location, LocalDate joinDate, LocalDate endDate, String desc, Profile profile) {
        this.id = id;
        this.role = role;
        this.company = company;
        this.location = location;
        this.joinDate = joinDate;
        this.endDate = endDate;
        this.des= desc;
        this.profile = profile;
    }
    public Exprience() {}


    public ExperienceDTO toExprienceDTO() {
        return new ExperienceDTO(id, role, company, location, joinDate, endDate, des, profile);
    }
}
