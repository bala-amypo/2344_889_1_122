package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.entity.DiscountCode;
import com.example.demo.entity.Influencer;
import com.example.demo.entity.Campaign;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.repository.InfluencerRepository;
import com.example.demo.repository.CampaignRepository;
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
    public DiscountCode createDiscountCode(DiscountCode discountCode) {

        if (discountCode.getInfluencer() != null) {
            Long influencerId = discountCode.getInfluencer().getId();
            Influencer influencer = influencerRepository.findById(influencerId)
                    .orElseThrow(() -> new ResourceNotFoundException("Influencer not found"));
            discountCode.setInfluencer(influencer);
        }

        if (discountCode.getCampaign() != null) {
            Long campaignId = discountCode.getCampaign().getId();
            Campaign campaign = campaignRepository.findById(campaignId)
                    .orElseThrow(() -> new ResourceNotFoundException("Campaign not found"));
            discountCode.setCampaign(campaign);
        }

        return discountCodeRepository.save(discountCode);
    }

    @Override
    public DiscountCode updateDiscountCode(Long id, DiscountCode discountCode) {

        DiscountCode existing = discountCodeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Discount code not found"));

        if (discountCode.getCodeValue() != null) {
            existing.setCodeValue(discountCode.getCodeValue());
        }

        if (discountCode.getDiscountPercentage() != null) {
            existing.setDiscountPercentage(discountCode.getDiscountPercentage());
        }

        return discountCodeRepository.save(existing);
    }

    @Override
    public DiscountCode getById(Long id) {
        return discountCodeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Discount code not found"));
    }

    @Override
    public List<DiscountCode> getByInfluencer(Long influencerId) {
        return discountCodeRepository.findByInfluencerId(influencerId);
    }

    @Override
    public List<DiscountCode> getByCampaign(Long campaignId) {
        return discountCodeRepository.findByCampaignId(campaignId);
    }
    @Override
    public DiscountCode deactivateCode(Long id) {

        DiscountCode code = discountCodeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Discount code not found"));

        code.setActive(false);
        return discountCodeRepository.save(code);
    }
}