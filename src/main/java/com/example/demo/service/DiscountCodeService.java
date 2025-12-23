package com.example.demo.service;

import com.example.demo.entity.DiscountCode;
import java.util.List;

public interface DiscountCodeService {

    DiscountCode createDiscountCode(DiscountCode discountCode);

    DiscountCode updateDiscountCode(Long id, DiscountCode discountCode);

    DiscountCode getById(Long id);

    List<DiscountCode> getByInfluencer(Long influencerId);

    List<DiscountCode> getByCampaign(Long campaignId);
    
    DiscountCode deactivateCode(Long id);
}