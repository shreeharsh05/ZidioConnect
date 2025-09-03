package com.JobFindingPlatform.entity;

import com.JobFindingPlatform.ENUM.Duration;
import com.JobFindingPlatform.ENUM.PlanName;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubscriptionPlan {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private PlanName planName;
    private Double price;
    private String currency;
    private Duration duration;
    private String features;

}
