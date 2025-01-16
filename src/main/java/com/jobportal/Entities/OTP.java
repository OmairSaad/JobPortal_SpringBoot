package com.jobportal.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class OTP {
    private String OTP;
    @Id
    private String email;
    private LocalDateTime creationTime;

    public String getOTP() {
        return OTP;
    }

    public void setOTP(String OTP) {
        this.OTP = OTP;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public OTP(String OTP, String email, LocalDateTime creationTime) {
        this.OTP = OTP;
        this.email = email;
        this.creationTime = creationTime;
    }
    public OTP() {}

}
