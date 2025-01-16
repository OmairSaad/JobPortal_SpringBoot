package com.jobportal.Controllers;

import com.jobportal.DTOS.LoginDTO;
import com.jobportal.DTOS.MailResponseDTO;
import com.jobportal.Services.MailService;
import jakarta.mail.MessagingException;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class ForgotPasswordController {
    @Autowired
    private MailService mailService;
    @PostMapping("/send-otp/{email}")
    public ResponseEntity<MailResponseDTO> sendOtp(@PathVariable String email) throws MessagingException {
        return new ResponseEntity<>(mailService.sendOtp(email), HttpStatus.OK);
    }

    @GetMapping("/verify-otp/{email}/{otp}")
    public ResponseEntity<MailResponseDTO> verifyOtp(@PathVariable @Email(message = "Invalid Email")
                                                         String email, @PathVariable @Pattern(regexp = "^[0-9]{6}$",message = "Otp invalid") String otp) {
        return new ResponseEntity<>(mailService.verifyOtp(email,otp),HttpStatus.OK);
    }

    @PostMapping("/change-password")
    public ResponseEntity<MailResponseDTO> changePaswword(@RequestBody LoginDTO loginDTO) {
        return new ResponseEntity<>(mailService.changePassword(loginDTO),HttpStatus.OK);
    }

}
