package com.jobportal.Repositories;

import com.jobportal.Entities.Profile;
import com.jobportal.Entities.Skills;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, Long> {
    List<Skills> getSkillsByProfile(Profile profile);
    Optional<Skills> findBySkillName(String name);
}
