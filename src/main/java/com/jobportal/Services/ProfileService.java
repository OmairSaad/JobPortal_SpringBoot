package com.jobportal.Services;

import com.jobportal.DTOS.ProfileDTO;
import com.jobportal.Entities.Profile;
import com.jobportal.Entities.User;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfileService {
    public Profile createProfile( User user);
    public List<ProfileDTO> getAllProfiles();
    public ProfileDTO getProfile(Long id);
    public ProfileDTO updateProfileInfo(Long userId,ProfileDTO profile);
    Profile updateProfileAbout(Long userId, ProfileDTO profile);
    ResponseEntity<String> updatePicture(Long userId, ProfileDTO profile);
}
