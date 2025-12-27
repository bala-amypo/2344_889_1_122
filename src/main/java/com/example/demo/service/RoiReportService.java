package com.example.demo.service;

import com.example.demo.model.RoiReport;
import java.util.List;

public interface RoiService {

    List<RoiReport> getReportsForInfluencer(Long influencerId);

    List<RoiReport> getReportsForCampaign(Long campaignId);
}
