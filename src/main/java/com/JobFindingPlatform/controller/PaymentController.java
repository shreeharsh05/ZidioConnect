package com.JobFindingPlatform.controller;



import com.JobFindingPlatform.dto.PaymentRequestDTO;
import com.JobFindingPlatform.entity.Payment;
import com.JobFindingPlatform.entity.SubscriptionPlan;
import com.JobFindingPlatform.repository.PaymentRepository;
import com.JobFindingPlatform.service.InvoiceService;
import com.JobFindingPlatform.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.JobFindingPlatform.dto.PaymentResponseDTO;

import com.JobFindingPlatform.repository.SubscriptionPlanRepository;
@RestController
@RequestMapping("api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private SubscriptionPlanRepository subPlanRepo;

    @Autowired
    private PaymentRepository paymentRepo;

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/process")
    public ResponseEntity<PaymentResponseDTO>process(@RequestBody PaymentRequestDTO dto ){
        return ResponseEntity.ok(paymentService.processPayment(dto));
    }

    @GetMapping("/plans")
    public ResponseEntity<List<SubscriptionPlan>> getPlans() {
        return ResponseEntity.ok(subPlanRepo.findAll());
    }

    @PostMapping("/plans")
    public ResponseEntity<SubscriptionPlan> createPlans(@RequestBody SubscriptionPlan plan) {
        return ResponseEntity.ok(subPlanRepo.save(plan));
    }
    @GetMapping("/history/{userId}")
    public ResponseEntity<List<Payment>>history(@PathVariable Long userId){
        return ResponseEntity.ok(paymentRepo.findUserById(userId));
    }


    @GetMapping("/invoice/{paymentId}")
    public ResponseEntity<byte[]>downloadInvoice(@PathVariable Long paymentId){

        Payment pay = paymentRepo.findById(paymentId).orElseThrow(()-> new RuntimeException("Payment not found"));
        byte[] pdfBytes = invoiceService.generateInvoice(pay);

        return ResponseEntity.ok()
                .header("Content-Diposition", "Attachment; fileNameInvoice-" +pay.getTransactionId() + ".pdf")
                .contentType(org.springframework.http.MediaType.APPLICATION_PDF).body(pdfBytes);
    }

}
