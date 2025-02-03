package com.jobportal.Services.ServiceImpl;

import com.jobportal.DTOS.CertificationsDTO;
import com.jobportal.Entities.Certifications;
import com.jobportal.Entities.Profile;
import com.jobportal.Repositories.CertificateRepository;
import com.jobportal.Repositories.ProfileRepository;
import com.jobportal.Services.CertificateService;
import com.jobportal.Utility.JobPortalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CertificationServiceImpl implements CertificateService {
    @Autowired
    private CertificateRepository certificateRepository;

    @Autowired
    private ProfileRepository profileRepository;
    @Override
    public List<CertificationsDTO> getCertifications() {
         return  certificateRepository.findAll().stream().map(Certifications::toDTO).collect(Collectors.toList());
    }

    @Override
    public CertificationsDTO getCertification(Long certificationId) {
        return certificateRepository.findById(certificationId).orElseThrow(()->new JobPortalException("Certification not found")).toDTO();
    }

    @Override
    public CertificationsDTO addCertification(CertificationsDTO certificationsDTO,Long id) {
        Profile profile = profileRepository.findById(id).orElseThrow(()->new JobPortalException("Profile not found"));
        Certifications certifications = certificationsDTO.toCertfications();
        certifications.setProfile(profile);
        return certificateRepository.save(certifications).toDTO();
    }

    @Override
    public List<CertificationsDTO> getCertificationsByProfileId(Long profileId) {
        Profile profile = profileRepository.findById(profileId).orElseThrow(()-> new JobPortalException("Profile not found"));
        return certificateRepository.findByProfile(profile).stream().map(Certifications::toDTO).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<String> deleteCertificate(Long id) {
        Certifications certifications = certificateRepository.findById(id).orElseThrow(()->new JobPortalException("Certification not found"));
        certificateRepository.delete(certifications);
        return new ResponseEntity<String>("Deleted Certification id: "+id, HttpStatus.OK);
    }


    @Override
    public CertificationsDTO updateCertification(Long id, CertificationsDTO certificationsDTO) {
        Profile profile = profileRepository.findById(id).orElseThrow(()->new JobPortalException("Profile not found"));
        Certifications certifications = certificationsDTO.toCertfications();
        certifications.setProfile(profile);
        return certificateRepository.save(certifications).toDTO();
    }
}
