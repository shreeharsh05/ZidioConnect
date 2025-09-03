package com.JobFindingPlatform.entity;

import com.JobFindingPlatform.ENUM.Action;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private Long adminId;
    private String username;
    private Action action;
    private LocalDateTime createdAt;


}
