package com.example.demo.controller;

import com.example.demo.service.RoiReportService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roi-reports")
public class RoiReportController {

    private final RoiReportService roiReportService;

    public RoiReportController(RoiReportService roiReportService) {
        this.roiReportService = roiReportService;
    }
}
