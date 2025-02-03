package com.jobportal.Controllers;

import com.jobportal.DTOS.LoginDTO;
import com.jobportal.DTOS.UserDTO;
import com.jobportal.Entities.User;
import com.jobportal.Repositories.UserRepository;
import com.jobportal.Services.ProfileService;
import com.jobportal.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Validated
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileService profileService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@Valid @RequestBody UserDTO userdto) {
        User user = userService.addUser(userdto.toUser());
        profileService.createProfile(user);
        return new ResponseEntity<>(user.toDTO(), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public UserDTO login(@Valid @RequestBody LoginDTO logindto) {
        User user = userRepository.findByEmail(logindto.getEmail());
        if(user == null) {
            throw new UsernameNotFoundException("Invalid email or password");
        }
        this.doAuthenticate(logindto.getEmail(), logindto.getPassword());
        return user.toDTO();
    }
    private void doAuthenticate(String email, String password) {
        UsernamePasswordAuthenticationToken t = new UsernamePasswordAuthenticationToken(email, password);
        try{
            authenticationManager.authenticate(t);
        }catch (Exception e) {
            throw new BadCredentialsException("Invalid email or password");
        }
    }
}
