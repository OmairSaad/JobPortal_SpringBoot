package com.jobportal.Repositories;

import com.jobportal.Entities.Profile;
import com.jobportal.Entities.ProfileSkill;
import com.jobportal.Entities.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProfileSkillRepository extends JpaRepository<ProfileSkill,Long> {
    List<ProfileSkill> getSkillsByProfile(Profile profile);

}
