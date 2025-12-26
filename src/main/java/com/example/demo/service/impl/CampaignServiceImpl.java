package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.entity.Campaign;
import com.example.demo.repository.CampaignRepository;
import com.example.demo.service.CampaignService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService {
    
    private final CampaignRepository campaignRepository;
    
    public CampaignServiceImpl(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }
    
    @Override
    public Campaign updateCampaign(Long campaignId, Campaign campaign) {
        Campaign existing = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        
        if (campaign.getEndDate() != null && campaign.getStartDate() != null && 
            campaign.getEndDate().isBefore(campaign.getStartDate())) {
            throw new IllegalArgumentException("End date cannot be before start date");
        }
        
        if (campaign.getCampaignName() != null) {
            existing.setCampaignName(campaign.getCampaignName());
        }
        if (campaign.getStartDate() != null) {
            existing.setStartDate(campaign.getStartDate());
        }
        if (campaign.getEndDate() != null) {
            existing.setEndDate(campaign.getEndDate());
        }
        
        return campaignRepository.save(existing);
    }
    
    @Override
    public Campaign getCampaignById(Long campaignId) {
        return campaignRepository.findById(campaignId)
                .orElseThrow(() -> new ResourceNotFoundException("Campaign not found"));
    }
    
    @Override
    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }
}
