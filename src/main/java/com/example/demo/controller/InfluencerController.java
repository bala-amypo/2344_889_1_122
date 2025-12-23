package com.example.demo.controller;

import com.example.demo.entity.Influencer;
import com.example.demo.service.InfluencerService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/influencers")
public class InfluencerController {

    private final InfluencerService influencerService;

    public InfluencerController(InfluencerService influencerService) {
        this.influencerService = influencerService;
    }

    @PostMapping
    public Influencer createInfluencer(@RequestBody Influencer influencer) {
        return influencerService.createInfluencer(influencer);
    }

    @GetMapping
    public List<Influencer> getAllInfluencers() {
        return influencerService.getAllInfluencers();
    }

    @GetMapping("/{id}")
    public Influencer getInfluencerById(@PathVariable Long id) {
        return influencerService.getInfluencerById(id);
    }
    @PutMapping("/{id}")
    public Influencer updateInfluencer(
            @PathVariable Long id,
            @RequestBody Influencer influencer) {
        return influencerService.updateInfluencer(id, influencer);
    }

    
    @PutMapping("/{id}/deactivate")
    public Influencer deactivateInfluencer(@PathVariable Long id) {
        return influencerService.deactivateInfluencer(id);
    }
}