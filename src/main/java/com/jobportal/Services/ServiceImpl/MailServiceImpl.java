package com.jobportal.Services.ServiceImpl;

import com.jobportal.DTOS.LoginDTO;
import com.jobportal.DTOS.MailResponseDTO;
import com.jobportal.Entities.OTP;
import com.jobportal.Entities.User;
import com.jobportal.Repositories.OTPRepository;
import com.jobportal.Repositories.UserRepository;
import com.jobportal.Services.MailService;
import com.jobportal.Utility.JobPortalException;
import com.jobportal.Utility.Utility;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private OTPRepository otpRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public MailResponseDTO sendOtp(String email) throws MessagingException {
        User user = userRepository.findByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage,true);
        message.setTo(email);
        message.setSubject("Your OTP code");
        String genOTP = Utility.generateOTP();
        OTP otp = new OTP(genOTP,email,LocalDateTime.now());
        otpRepository.save(otp);
        message.setText(Utility.HtmlTemplate(genOTP),true);
        mailSender.send(mimeMessage);
        return new MailResponseDTO("Otp sent successfully");
    }

    @Override
    public MailResponseDTO verifyOtp(String email, String otp) {
       OTP otpEnt= otpRepository.findById(email).orElseThrow(()-> new UsernameNotFoundException("Otp invalid"));
        if(!otpEnt.getOTP().equals(otp)) {
            throw new JobPortalException("OTP do not match");
        }
        if(otpEnt.getCreationTime().plusMinutes(10).isBefore(LocalDateTime.now())) {
            throw new JobPortalException("Otp already expired");
        }
        return new MailResponseDTO("OTP verified successfully");
    }

    @Override
    public MailResponseDTO changePassword(LoginDTO loginDTO) {
        User user = userRepository.findByEmail(loginDTO.getEmail());
        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        user.setPassword(passwordEncoder.encode(loginDTO.getPassword()));
        userRepository.save(user);
        return new MailResponseDTO("Password changed successfully");
    }


//    @Scheduled(fixedRate = 5000)
//    public void delAllExpiredOTP(){
//        List<OTP> otps = otpRepository.findByCreationTimeBefore(LocalDateTime.now().minusMinutes(15));
//        otpRepository.deleteAll(otps);
//    }

}
