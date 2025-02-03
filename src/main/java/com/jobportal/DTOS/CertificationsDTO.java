package com.jobportal.DTOS;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobportal.Entities.Certifications;
import com.jobportal.Entities.Profile;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public class CertificationsDTO {
    private Long id;
    private String certificate;
    private String company;
    private LocalDate issueDate;
    private String certificateId;
    @ManyToOne( fetch = FetchType.EAGER , cascade = CascadeType.ALL)
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

    public CertificationsDTO(Long id, String certificate, String company, LocalDate issueDate, String certificateId, Profile profile) {
        this.id = id;
        this.certificate = certificate;
        this.company = company;
        this.issueDate = issueDate;
        this.certificateId = certificateId;
        this.profile = profile;
    }
    public CertificationsDTO() {}

    public Certifications toCertfications(){
        return new Certifications(id,certificate,company,issueDate,certificateId,profile);
    }
}
