package com.example.demo.controller;

import com.example.demo.model.RoiReport;
import com.example.demo.service.RoiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roi")
public class RoiReportController {
    
    private final RoiService roiService;
    
    public RoiReportController(RoiService roiService) {
        this.roiService = roiService;
    }
    
    @PostMapping("/code/{discountCodeId}")
    public ResponseEntity<RoiReport> generateReportForCode(@PathVariable Long discountCodeId) {
        RoiReport report = roiService.generateReportForCode(discountCodeId);
        return ResponseEntity.ok(report);
    }
    
    @GetMapping("/{reportId}")
    public ResponseEntity<RoiReport> getReportById(@PathVariable Long reportId) {
        RoiReport report = roiService.getReportById(reportId);
        return ResponseEntity.ok(report);
    }
    
    @GetMapping("/influencer/{influencerId}")
    public ResponseEntity<List<RoiReport>> getReportsForInfluencer(@PathVariable Long influencerId) {
        List<RoiReport> reports = roiService.getReportsForInfluencer(influencerId);
        return ResponseEntity.ok(reports);
    }
}