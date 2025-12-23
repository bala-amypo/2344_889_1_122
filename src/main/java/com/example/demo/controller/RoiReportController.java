package com.example.demo.controller;

import com.example.demo.entity.RoiReport;
import com.example.demo.service.RoiReportService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roi")
public class RoiReportController {

    private final RoiReportService roiService;

    public RoiReportController(RoiReportService roiService) {
        this.roiService = roiService;
    }

    @PostMapping("/generate/{codeId}")
    public RoiReport generateRoi(@PathVariable Long codeId) {
        return roiService.generateReportForCode(codeId);
    }

    @GetMapping("/{id}")
    public RoiReport getRoiById(@PathVariable Long id) {
        return roiService.getReportById(id);
    }

    @GetMapping("/influencer/{influencerId}")
    public List<RoiReport> getRoiByInfluencer(@PathVariable Long influencerId) {
        return roiService.getReportsForInfluencer(influencerId);
    }

    @GetMapping("/campaign/{campaignId}")
    public List<RoiReport> getRoiByCampaign(@PathVariable Long campaignId) {
        return roiService.getReportsForCampaign(campaignId);
    }
}
