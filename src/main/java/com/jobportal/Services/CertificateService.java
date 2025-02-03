package com.jobportal.Services;

import com.jobportal.DTOS.CertificationsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CertificateService {
     List<CertificationsDTO> getCertifications();
     CertificationsDTO getCertification(Long certificationId);
     CertificationsDTO addCertification(CertificationsDTO certificationsDTO, Long id);
    List<CertificationsDTO> getCertificationsByProfileId(Long profileId);
    ResponseEntity<String> deleteCertificate(Long id);
    CertificationsDTO updateCertification(Long id, CertificationsDTO certificationsDTO);
}
