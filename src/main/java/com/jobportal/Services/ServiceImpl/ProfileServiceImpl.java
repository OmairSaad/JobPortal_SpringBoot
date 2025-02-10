package com.jobportal.Services.ServiceImpl;

import com.jobportal.DTOS.ProfileDTO;
import com.jobportal.Entities.Profile;
import com.jobportal.Entities.User;
import com.jobportal.Repositories.ProfileRepository;
import com.jobportal.Repositories.UserRepository;
import com.jobportal.Services.ProfileService;
import com.jobportal.Utility.JobPortalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public Profile createProfile(User user) {
        Profile profile = new Profile();
        profile.setUser(user);
        profile.setEmail(user.getEmail());
        profile.setName(user.getName());
        profile.setAbout("About: temps");
        profile.setLocation("Address");
        profile.setCompany("Company");
        profile.setRole("Software Engineer");
        return profileRepository.save(profile);
    }

    @Override
    public List<ProfileDTO> getAllProfiles() {
        return profileRepository.findAll().stream().map(Profile::toDTO).collect(Collectors.toList());
    }

    @Override
    public ProfileDTO getProfile(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new JobPortalException("User Not Found"));
        return profileRepository.findByUser(user).toDTO();
    }

    @Override
    public ProfileDTO updateProfileInfo(Long userId, ProfileDTO profile) {
        Profile pr = profileRepository.findById(userId).orElseThrow(()->new JobPortalException("User Not Found"));
        pr.setRole(profile.getRole());
        pr.setCompany(profile.getCompany());
        pr.setLocation(profile.getLocation());
        return profileRepository.save(pr).toDTO();
    }

    @Override
    public Profile updateProfileAbout(Long userId, ProfileDTO profile) {
        Profile pr = profileRepository.findById(userId).orElseThrow(()->new JobPortalException("User Not Found"));
        pr.setAbout(profile.getAbout());
        return profileRepository.save(pr);
    }

    @Override
    public ResponseEntity<String> updatePicture(Long userId, ProfileDTO profile) {
        Profile pr = profileRepository.findById(userId).orElseThrow(()->new JobPortalException("User Not Found"));
        pr.setPicture(profile.toProfile().getPicture());
        profileRepository.save(pr);
        return ResponseEntity.ok("Profile Updated");
    }


    @Override
    public ProfileDTO getProfileById(Long profileId) {
        return profileRepository.findById(profileId).orElseThrow(()->new JobPortalException("Profile not found!")).toDTO();
    }
}
