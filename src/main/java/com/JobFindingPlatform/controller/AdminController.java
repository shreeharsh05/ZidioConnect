package com.JobFindingPlatform.controller;
import com.JobFindingPlatform.dto.AdminDTO;
import com.JobFindingPlatform.entity.Admin;
import com.JobFindingPlatform.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {


    private final AdminService adminService;

    @PostMapping("/action")
    public ResponseEntity<Admin> adminLogin(@RequestBody AdminDTO adminDTO) {
        return ResponseEntity.ok(adminService.performanceAction(adminDTO));
    }

    @GetMapping("/admin/{adminId}")
    public ResponseEntity<List<Admin>> getAllAdmins(@PathVariable Long adminId) {
        return ResponseEntity.ok(adminService.getActionsByAdmin(adminId));
    }

    @GetMapping("/admin/{userId}")
    public  ResponseEntity<List<Admin>> getAllAdminsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(adminService.getActionsByUser(userId));
    }

}
