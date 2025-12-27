package com.example.demo.service.impl;

import com.example.demo.model.DiscountCode;
import com.example.demo.repository.CampaignRepository;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.repository.InfluencerRepository;
import com.example.demo.service.DiscountCodeService;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {

    private final DiscountCodeRepository discountCodeRepository;
    private final InfluencerRepository influencerRepository;
    private final CampaignRepository campaignRepository;

    public DiscountCodeServiceImpl(
            DiscountCodeRepository discountCodeRepository,
            InfluencerRepository influencerRepository,
            CampaignRepository campaignRepository) {

        this.discountCodeRepository = discountCodeRepository;
        this.influencerRepository = influencerRepository;
        this.campaignRepository = campaignRepository;
    }

    @Override
    public DiscountCode createDiscountCode(DiscountCode code) {
        return discountCodeRepository.save(code);
    }

    @Override
    public DiscountCode updateDiscountCode(Long id, DiscountCode code) {
        DiscountCode existing = discountCodeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Discount code not found"));

        existing.setCodeValue(code.getCodeValue());
        existing.setDiscountPercentage(code.getDiscountPercentage());

        return discountCodeRepository.save(existing);
    }

    @Override
    public DiscountCode getDiscountCodeById(Long id) {
        return discountCodeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Discount code not found"));
    }

    @Override
    public List<DiscountCode> getCodesForInfluencer(Long influencerId) {
        return discountCodeRepository.findByInfluencer_Id(influencerId);
    }

    @Override
    public List<DiscountCode> getCodesForCampaign(Long campaignId) {
        return discountCodeRepository.findByCampaign_Id(campaignId);
    }

    @Override
    public void deactivateCode(Long id) {
        DiscountCode code = getDiscountCodeById(id);
        code.setActive(false);
        discountCodeRepository.save(code);
    }
}
