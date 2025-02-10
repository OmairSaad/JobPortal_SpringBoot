package com.jobportal.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jobportal.DTOS.ProfileDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String name;
    private String role;
    private String location;
    @Column(name="about",length = 2000)
    private String about;
    @Lob
    private byte[] picture;
    private String company;
    @OneToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"profile"})
    @JsonIgnore
    private User user;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "profile-skills",
            joinColumns = @JoinColumn(name = "profile-id"),
            inverseJoinColumns = @JoinColumn(name = "skill-id")
    )
    private List<Skills> skills = new ArrayList<>();

    @OneToMany(mappedBy = "profile",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Exprience> expriences = new ArrayList<>();

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Certifications> certifications = new ArrayList<>();

    public String getRole() {

        return role;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

//    public List<ProfileSkill> getSkills() {
//        return skills;
//    }
//
//    public void setSkills(List<ProfileSkill> skills) {
//        this.skills = skills;
//    }


    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Profile(Long id, String email, String name, String role, String location, String about, byte[] picture, String company, User user, List<Skills> skills, List<Exprience> expriences, List<Certifications> certifications) {
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
    }

    public Profile() {}

    public ProfileDTO toDTO(){
        return new ProfileDTO(id,email,name,role,location,about, this.picture!=null? Base64.getEncoder().encodeToString(this.picture):null,company,user,skills,expriences,certifications,null);
    }
}
