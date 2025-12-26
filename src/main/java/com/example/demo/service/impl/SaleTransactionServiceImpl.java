package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.entity.SaleTransaction;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.SaleTransactionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {
    
    private final SaleTransactionRepository saleTransactionRepository;
    private final DiscountCodeRepository discountCodeRepository;
    
    public SaleTransactionServiceImpl(SaleTransactionRepository saleTransactionRepository, 
                                    DiscountCodeRepository discountCodeRepository) {
        this.saleTransactionRepository = saleTransactionRepository;
        this.discountCodeRepository = discountCodeRepository;
    }
    
    @Override
    public SaleTransaction createSale(SaleTransaction transaction) {
        if (transaction.getTransactionAmount() == null || 
            transaction.getTransactionAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Transaction amount must be > 0");
        }
        
        if (transaction.getDiscountCode() != null && transaction.getDiscountCode().getId() != null) {
            discountCodeRepository.findById(transaction.getDiscountCode().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Discount code not found"));
        }
        
        if (transaction.getTransactionDate() == null) {
            transaction.setTransactionDate(new Timestamp(System.currentTimeMillis()));
        }
        
        return saleTransactionRepository.save(transaction);
    }
    
    @Override
    public List<SaleTransaction> getSalesForCode(Long discountCodeId) {
        return saleTransactionRepository.findByDiscountCodeId(discountCodeId);
    }
    
    @Override
    public List<SaleTransaction> getSalesForInfluencer(Long influencerId) {
        return saleTransactionRepository.findByDiscountCodeInfluencerId(influencerId);
    }
    
    @Override
    public List<SaleTransaction> getSalesForCampaign(Long campaignId) {
        return saleTransactionRepository.findByDiscountCodeCampaignId(campaignId);
    }
}
