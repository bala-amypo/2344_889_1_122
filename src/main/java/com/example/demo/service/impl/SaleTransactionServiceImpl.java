package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DiscountCode;
import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.SaleTransactionService;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    private final SaleTransactionRepository saleTransactionRepository;
    private final DiscountCodeRepository discountCodeRepository;

    public SaleTransactionServiceImpl(
            SaleTransactionRepository saleTransactionRepository,
            DiscountCodeRepository discountCodeRepository) {
        this.saleTransactionRepository = saleTransactionRepository;
        this.discountCodeRepository = discountCodeRepository;
    }

    @Override
    public SaleTransaction logTransaction(SaleTransaction transaction) {

        
        if (transaction.getSaleAmount() == null
                || transaction.getSaleAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Sale amount must be > 0");
        }

        
        Long codeId = transaction.getDiscountCode().getId();

        DiscountCode code = discountCodeRepository.findById(codeId)
                .orElseThrow(() -> new ResourceNotFoundException("Discount code not found"));

        transaction.setDiscountCode(code);

        
        return saleTransactionRepository.save(transaction);
    }

    @Override
public List<SaleTransaction> getSalesForCode(Long discountCodeId) {
    return saleTransactionRepository.findByDiscountCode_Id(discountCodeId);
}

@Override
public List<SaleTransaction> getSalesForInfluencer(Long influencerId) {
    return saleTransactionRepository.findByDiscountCode_Influencer_Id(influencerId);
}

@Override
public List<SaleTransaction> getSalesForCampaign(Long campaignId) {
    return saleTransactionRepository.findByDiscountCode_Campaign_Id(campaignId);
}

    @Override
    public SaleTransaction getTransactionById(Long id) {
        return saleTransactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sale not found"));
    }
}