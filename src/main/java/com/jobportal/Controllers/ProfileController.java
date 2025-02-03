package com.jobportal.Controllers;

import com.jobportal.DTOS.ProfileDTO;
import com.jobportal.Entities.Profile;
import com.jobportal.Services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
@CrossOrigin(origins = "http://localhost:5173")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping("")
    private List<ProfileDTO> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    @GetMapping("{userId}")
    private ProfileDTO getProfile(@PathVariable Long userId) {
        return  profileService.getProfile(userId);
    }

    //changing only role,company and location in profile info
    @PutMapping("{userId}/info")
    private ProfileDTO updateProfileInfo(@PathVariable Long userId, @RequestBody ProfileDTO profile) {
        return profileService.updateProfileInfo(userId, profile);
    }

    @PutMapping("{userId}/about")
    private Profile updateProfileAbout(@PathVariable Long userId, @RequestBody ProfileDTO profile) {
        return profileService.updateProfileAbout(userId, profile);
    }

    @PutMapping("/update-picture/{userId}")
    private ResponseEntity<String> updateProfilePicture(@PathVariable Long userId, @RequestBody ProfileDTO profile) {
        return profileService.updatePicture(userId,profile);
    }
}
