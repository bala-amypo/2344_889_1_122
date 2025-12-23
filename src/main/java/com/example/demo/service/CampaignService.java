package com.example.demo.service;

import com.example.demo.entity.Campaign;
import java.util.List;

public interface CampaignService {

    Campaign createCampaign(Campaign campaign);

    Campaign updateCampaign(Long id, Campaign campaign);

    Campaign getCampaignById(Long id);

    List<Campaign> getAllCampaigns();
    Campaign deactivateCampaign(Long id);
}