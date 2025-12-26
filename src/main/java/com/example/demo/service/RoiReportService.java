package com.example.demo.service;

import com.example.demo.entity.RoiReport;
import java.util.List;

public interface RoiReportService {

    List<RoiReport> getByInfluencerId(Long influencerId);

    List<RoiReport> getByCampaignId(Long campaignId);
}
