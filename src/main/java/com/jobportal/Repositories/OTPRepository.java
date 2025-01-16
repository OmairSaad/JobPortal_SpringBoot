package com.jobportal.Repositories;

import com.jobportal.Entities.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OTPRepository extends JpaRepository<OTP,String> {
    List<OTP> findByCreationTimeBefore(LocalDateTime time);
}
