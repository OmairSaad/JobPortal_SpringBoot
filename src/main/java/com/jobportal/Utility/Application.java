package com.jobportal.Utility;

import java.time.LocalDateTime;

public class Application {
    private LocalDateTime interviewDate;
    private String interviewTime;
    private ApplicationStatus applicationStatus;

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

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public Application(LocalDateTime interviewDate, String interviewTime, ApplicationStatus applicationStatus) {
        this.interviewDate = interviewDate;
        this.interviewTime = interviewTime;
        this.applicationStatus = applicationStatus;
    }

}
