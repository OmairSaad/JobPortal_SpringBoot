package com.jobportal.Repositories;

import com.jobportal.Entities.Certifications;
import com.jobportal.Entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.security.cert.Certificate;
import java.util.List;

@Repository
public interface CertificateRepository extends JpaRepository<Certifications, Long> {
    List<Certifications> findByProfile(Profile profile);
}
