package com.JobFindingPlatform.repository;

import com.JobFindingPlatform.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    List<Admin>  findByAdminId(Long adminId);
    List<Admin>  findByUserId(Long userId);
}
