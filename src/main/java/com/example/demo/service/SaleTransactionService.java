package com.example.demo.service;

import com.example.demo.entity.SaleTransaction;
import java.util.List;

public interface SaleTransactionService {
    SaleTransaction createSale(SaleTransaction transaction);
    List<SaleTransaction> getSalesForCode(Long discountCodeId);
    List<SaleTransaction> getSalesForInfluencer(Long influencerId);
    List<SaleTransaction> getSalesForCampaign(Long campaignId);
}
