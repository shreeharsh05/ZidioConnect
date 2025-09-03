package com.JobFindingPlatform.dto;

import com.JobFindingPlatform.ENUM.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequestDTO {


    private Long userId;
    private Long planId;
    private Double amount;
}
