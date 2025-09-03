package com.JobFindingPlatform.repository;

import com.JobFindingPlatform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRespository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
