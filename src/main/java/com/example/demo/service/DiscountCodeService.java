package com.example.demo.service;

import com.example.demo.model.DiscountCode;
import java.util.List;

public interface DiscountCodeService {

    DiscountCode createDiscountCode(DiscountCode code);

    DiscountCode updateDiscountCode(Long id, DiscountCode code);

    DiscountCode getDiscountCodeById(Long id);

    List<DiscountCode> getCodesForInfluencer(Long influencerId);

    List<DiscountCode> getCodesForCampaign(Long campaignId);

    void deactivateCode(Long id);
}
