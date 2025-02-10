package com.jobportal.Entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jobportal.DTOS.LoginDTO;
import com.jobportal.DTOS.UserDTO;
import com.jobportal.Utility.ROLE;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String password;

    @Column (unique = true, nullable = false)
    private String email;
    private ROLE role = ROLE.NORMAL;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"user"})
    private Profile profile;

    @OneToMany(mappedBy = "user")
    private List<Job> jobs = new ArrayList<Job>();
    @OneToMany(mappedBy = "user")
    private List<Applicant> applicants = new ArrayList<>();

    //for save jobs
    @ManyToMany
    @JoinTable(
            name = "saved-jobs",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "job-id")
    )
    private List<Job> savedJobs = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }

    public List<Applicant> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<Applicant> applicants) {
        this.applicants = applicants;
    }

    public List<Job> getSavedJobs() {
        return savedJobs;
    }

    public void setSavedJobs(List<Job> savedJobs) {
        this.savedJobs = savedJobs;
    }

    public User(Long id, String name, String password, String email, ROLE role, Profile profile, List<Job> jobs, List<Applicant> applicants, List<Job> savedJobs) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;
        this.profile = profile;
        this.jobs = jobs;
        this.applicants = applicants;
        this.savedJobs = savedJobs;
    }

    public User() {
    }

    public UserDTO toDTO() {
        return new UserDTO(id, name, password, email, role,profile, jobs, applicants, savedJobs);
    }

    public LoginDTO toLoginDTO() {
        return new LoginDTO(email,password);
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
}
