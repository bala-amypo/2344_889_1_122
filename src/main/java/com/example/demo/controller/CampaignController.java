package com.example.demo.controller;

import com.example.demo.entity.Campaign;
import com.example.demo.service.CampaignService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campaigns")
public class CampaignController {
    
    private final CampaignService campaignService;
    
    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Campaign> updateCampaign(@PathVariable Long id, @RequestBody Campaign campaign) {
        Campaign updated = campaignService.updateCampaign(id, campaign);
        return ResponseEntity.ok(updated);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Campaign> getCampaignById(@PathVariable Long id) {
        Campaign campaign = campaignService.getCampaignById(id);
        return ResponseEntity.ok(campaign);
    }
    
    @GetMapping
    public ResponseEntity<List<Campaign>> getAllCampaigns() {
        List<Campaign> campaigns = campaignService.getAllCampaigns();
        return ResponseEntity.ok(campaigns);
    }
}
