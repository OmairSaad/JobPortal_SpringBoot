package com.jobportal.Repositories;

import com.jobportal.Entities.Job;
import com.jobportal.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>{
    List<Job> findByUser(User user);
}
