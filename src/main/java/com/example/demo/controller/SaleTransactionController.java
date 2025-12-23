package com.example.demo.controller;

import com.example.demo.entity.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
public class SaleTransactionController {

    private final SaleTransactionService saleTransactionService;

    public SaleTransactionController(SaleTransactionService saleTransactionService) {
        this.saleTransactionService = saleTransactionService;
    }

    @PostMapping
    public SaleTransaction logTransaction(@RequestBody SaleTransaction transaction) {
        return saleTransactionService.logTransaction(transaction);
    }

    @GetMapping("/code/{discountCodeId}")
    public List<SaleTransaction> byCode(@PathVariable Long discountCodeId) {
        return saleTransactionService.getSalesForCode(discountCodeId);
    }

    @GetMapping("/influencer/{influencerId}")
    public List<SaleTransaction> byInfluencer(@PathVariable Long influencerId) {
        return saleTransactionService.getSalesForInfluencer(influencerId);
    }

    @GetMapping("/campaign/{campaignId}")
    public List<SaleTransaction> byCampaign(@PathVariable Long campaignId) {
        return saleTransactionService.getSalesForCampaign(campaignId);
    }
    @GetMapping("/{id}")
    public SaleTransaction getSaleById(@PathVariable Long id) {
        return saleTransactionService.getTransactionById(id);
    }
}