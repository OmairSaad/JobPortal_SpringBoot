package com.jobportal.Services;

import com.jobportal.Entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User addUser(User user);
}
