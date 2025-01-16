package com.jobportal.DTOS;


public class MailResponseDTO {
    private String message;

    public MailResponseDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
