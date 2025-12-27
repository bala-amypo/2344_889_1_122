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

    @GetMapping("/influencer/{id}")
    public ResponseEntity<List<RoiReport>> getReportsForInfluencer(@PathVariable Long id) {
        return ResponseEntity.ok(roiService.getReportsForInfluencer(id));
    }
}
