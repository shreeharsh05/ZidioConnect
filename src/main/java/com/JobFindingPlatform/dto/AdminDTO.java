package com.JobFindingPlatform.dto;


import com.JobFindingPlatform.ENUM.Action;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminDTO {

    private Long id;
    private Long userId;
    private Long adminId;
    private String username;
    private Action action;
    private LocalDateTime createdAt;

}
