package com.example.demo.controller;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/codes")
public class DiscountCodeController {

    private final DiscountCodeService discountCodeService;

    public DiscountCodeController(DiscountCodeService discountCodeService) {
        this.discountCodeService = discountCodeService;
    }

    @PostMapping
    public ResponseEntity<DiscountCode> createDiscountCode(@RequestBody DiscountCode code) {
        return ResponseEntity.ok(discountCodeService.createDiscountCode(code));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiscountCode> updateDiscountCode(
            @PathVariable Long id,
            @RequestBody DiscountCode code) {
        return ResponseEntity.ok(discountCodeService.updateDiscountCode(id, code));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscountCode> getDiscountCode(@PathVariable Long id) {
        return ResponseEntity.ok(discountCodeService.getDiscountCodeById(id));
    }

    @GetMapping("/influencer/{influencerId}")
    public ResponseEntity<List<DiscountCode>> getCodesForInfluencer(
            @PathVariable Long influencerId) {
        return ResponseEntity.ok(discountCodeService.getCodesForInfluencer(influencerId));
    }

    @GetMapping("/campaign/{campaignId}")
    public ResponseEntity<List<DiscountCode>> getCodesForCampaign(
            @PathVariable Long campaignId) {
        return ResponseEntity.ok(discountCodeService.getCodesForCampaign(campaignId));
    }
}
