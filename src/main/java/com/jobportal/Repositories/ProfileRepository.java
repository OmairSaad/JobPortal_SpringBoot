package com.jobportal.Repositories;

import com.jobportal.Entities.Profile;
import com.jobportal.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long> {
    Profile findByUser(User user);
}
