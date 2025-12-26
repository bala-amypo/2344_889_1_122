package com.example.demo.controller;

import com.example.demo.entity.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleTransactionController {
    
    private final SaleTransactionService saleTransactionService;
    
    public SaleTransactionController(SaleTransactionService saleTransactionService) {
        this.saleTransactionService = saleTransactionService;
    }
    
    @PostMapping
    public ResponseEntity<SaleTransaction> createSale(@RequestBody SaleTransaction transaction) {
        SaleTransaction created = saleTransactionService.createSale(transaction);
        return ResponseEntity.ok(created);
    }
    
    @GetMapping("/code/{discountCodeId}")
    public ResponseEntity<List<SaleTransaction>> getSalesForCode(@PathVariable Long discountCodeId) {
        List<SaleTransaction> sales = saleTransactionService.getSalesForCode(discountCodeId);
        return ResponseEntity.ok(sales);
    }
    
    @GetMapping("/influencer/{influencerId}")
    public ResponseEntity<List<SaleTransaction>> getSalesForInfluencer(@PathVariable Long influencerId) {
        List<SaleTransaction> sales = saleTransactionService.getSalesForInfluencer(influencerId);
        return ResponseEntity.ok(sales);
    }
    
    @GetMapping("/campaign/{campaignId}")
    public ResponseEntity<List<SaleTransaction>> getSalesForCampaign(@PathVariable Long campaignId) {
        List<SaleTransaction> sales = saleTransactionService.getSalesForCampaign(campaignId);
        return ResponseEntity.ok(sales);
    }
}
