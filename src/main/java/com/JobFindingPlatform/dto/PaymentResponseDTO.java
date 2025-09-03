package com.JobFindingPlatform.dto;
import com.JobFindingPlatform.ENUM.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class PaymentResponseDTO {
    private String transactionId;
    private PaymentStatus paymentStatus;
    private Double amount;
}
