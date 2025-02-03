package com.jobportal.Controllers;

import com.jobportal.DTOS.CertificationsDTO;
import com.jobportal.Services.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certifications")
@CrossOrigin(origins = "http://localhost:5173")
public class CertificationController {
    @Autowired
    private CertificateService certificateService;

    @GetMapping("")
    public List<CertificationsDTO> getAllCertifications() {
        return certificateService.getCertifications();
    }
    @GetMapping("/{profileId}")
    public List<CertificationsDTO> getCertificationsByProfileId(@PathVariable Long profileId) {
        return certificateService.getCertificationsByProfileId(profileId);
    }
    @PostMapping("/{profileId}")
    public CertificationsDTO addCertification(@RequestBody CertificationsDTO certificationsDTO ,@PathVariable Long profileId) {
        return certificateService.addCertification(certificationsDTO,profileId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCertification(@PathVariable Long id) {
        return certificateService.deleteCertificate(id);
    }

    @PutMapping("/{id}")
    public CertificationsDTO updateCertification(@PathVariable Long id, @RequestBody CertificationsDTO certificationsDTO) {
        return certificateService.updateCertification(id,certificationsDTO);
    }
}
