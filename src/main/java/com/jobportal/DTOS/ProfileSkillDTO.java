package com.jobportal.DTOS;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobportal.Entities.Profile;
import com.jobportal.Entities.ProfileSkill;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

public class ProfileSkillDTO {
    private Long id;
    private String skillName;
    private Profile profile;

    public ProfileSkillDTO(Long id, String skillName, Profile profile) {
        this.id = id;
        this.skillName = skillName;
        this.profile = profile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public ProfileSkill toProfileSkill() {
        return new ProfileSkill(id, skillName, profile);
    }
}
