package com.jobportal.Repositories;

import com.jobportal.Entities.Exprience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Exprience,Long> {
}
