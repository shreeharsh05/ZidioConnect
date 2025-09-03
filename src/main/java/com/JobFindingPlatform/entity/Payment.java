package com.JobFindingPlatform.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.JobFindingPlatform.ENUM.PaymentStatus;
import java.time.LocalDateTime;

@Data
@Table(name="plans")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private Long planId;
    private Double amount;
    private PaymentStatus status;
    private String transactionId;
    private LocalDateTime localDateTime;


}
