package com.example.demo.controller;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/influencers")
public class InfluencerController {
    
    private final InfluencerService influencerService;
    
    public InfluencerController(InfluencerService influencerService) {
        this.influencerService = influencerService;
    }
    
    @PostMapping
    public ResponseEntity<Influencer> createInfluencer(@RequestBody Influencer influencer) {
        Influencer created = influencerService.createInfluencer(influencer);
        return ResponseEntity.ok(created);
    }
    
    @GetMapping
    public ResponseEntity<List<Influencer>> getAllInfluencers() {
        List<Influencer> influencers = influencerService.getAllInfluencers();
        return ResponseEntity.ok(influencers);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Influencer> getInfluencerById(@PathVariable Long id) {
        Influencer influencer = influencerService.getInfluencerById(id);
        return ResponseEntity.ok(influencer);
    }
}