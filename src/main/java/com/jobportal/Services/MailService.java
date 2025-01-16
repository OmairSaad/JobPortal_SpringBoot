package com.jobportal.Services;

import com.jobportal.DTOS.LoginDTO;
import com.jobportal.DTOS.MailResponseDTO;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

@Service
public interface MailService {
    public MailResponseDTO sendOtp(String email) throws MessagingException;

   public MailResponseDTO verifyOtp(String email, String otp);

    public MailResponseDTO changePassword(LoginDTO loginDTO);

}
