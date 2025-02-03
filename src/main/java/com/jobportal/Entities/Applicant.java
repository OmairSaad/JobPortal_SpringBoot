package com.jobportal.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobportal.Utility.ApplicationStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long applicantId;
    private LocalDateTime timestamp;
    private ApplicationStatus applicationStatus;
    private String name;
    private String email;
    private String phone;
    private String website;
    private String cover;
    private byte[] resume;
    @ManyToOne
    @JsonIgnore
    private Job job;
    @ManyToOne
    @JsonIgnore
    private User user;
}
