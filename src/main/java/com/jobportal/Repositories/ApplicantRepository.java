package com.jobportal.Repositories;

import com.jobportal.Entities.Applicant;
import com.jobportal.Entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant,Long> {
    List<Applicant> findApplicantsByJob(Job job);
}
