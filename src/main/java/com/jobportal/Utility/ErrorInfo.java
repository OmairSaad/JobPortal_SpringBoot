package com.jobportal.Utility;


import java.util.Date;


public class ErrorInfo {
    private String errorMessage;
    private int errorCode;
    private Date timestamp;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public ErrorInfo(String errorMessage, int errorCode, Date timestamp) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.timestamp = timestamp;
    }
}
