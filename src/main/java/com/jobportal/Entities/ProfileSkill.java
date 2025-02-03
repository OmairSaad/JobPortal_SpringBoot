package com.jobportal.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobportal.DTOS.ProfileSkillDTO;
import jakarta.persistence.*;

@Entity
public class ProfileSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String skillName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Profile profile;

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

    public ProfileSkill(Long id, String skillName, Profile profile) {
        this.id = id;
        this.skillName = skillName;
        this.profile = profile;
    }
    public ProfileSkill() {}

    public ProfileSkillDTO toDTO(){
        return new ProfileSkillDTO(id, skillName, profile);
    }
}
