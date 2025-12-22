package com.example.demo.controller;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/discount-codes")
public class DiscountCodeController {

    private final DiscountCodeService discountCodeService;

    public DiscountCodeController(DiscountCodeService discountCodeService) {
        this.discountCodeService = discountCodeService;
    }

    @PostMapping
    public DiscountCode createDiscountCode(@RequestBody DiscountCode discountCode) {
        return discountCodeService.createDiscountCode(discountCode);
    }

    @PutMapping("/{id}")
    public DiscountCode updateDiscountCode(
            @PathVariable Long id,
            @RequestBody DiscountCode discountCode) {
        return discountCodeService.updateDiscountCode(id, discountCode);
    }

    @GetMapping("/{id}")
    public DiscountCode getDiscountCodeById(@PathVariable Long id) {
        return discountCodeService.getById(id);
    }

    @GetMapping("/influencer/{influencerId}")
    public List<DiscountCode> getCodesByInfluencer(@PathVariable Long influencerId) {
        return discountCodeService.getByInfluencer(influencerId);
    }

    @GetMapping("/campaign/{campaignId}")
    public List<DiscountCode> getCodesByCampaign(@PathVariable Long campaignId) {
        return discountCodeService.getByCampaign(campaignId);
    }
    @PutMapping("/{id}/deactivate")
    public DiscountCode deactivateCode(@PathVariable Long id) {
        return discountCodeService.deactivateCode(id);
    }
}