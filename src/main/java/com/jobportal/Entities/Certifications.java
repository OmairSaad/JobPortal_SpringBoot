package com.jobportal.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobportal.DTOS.CertificationsDTO;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Certifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String certificate;
    private String company;
    private LocalDate issueDate;
    private String certificateId;
    @ManyToOne( fetch = FetchType.LAZY)
    @JsonIgnore
    private Profile profile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Certifications(Long id, String certificate, String company, LocalDate issueDate, String certificateId, Profile profile) {
        this.id = id;
        this.certificate = certificate;
        this.company = company;
        this.issueDate = issueDate;
        this.certificateId = certificateId;
        this.profile = profile;
    }
    public Certifications() {}

    public CertificationsDTO toDTO(){
        return new CertificationsDTO(id, certificate, company, issueDate, certificateId, profile);
    }
}
