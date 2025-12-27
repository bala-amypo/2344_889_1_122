package com.example.demo.service.impl;

import com.example.demo.model.RoiReport;
import com.example.demo.repository.RoiReportRepository;
import com.example.demo.service.RoiService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoiServiceImpl implements RoiService {

    private final RoiReportRepository roiReportRepository;

    public RoiServiceImpl(RoiReportRepository roiReportRepository) {
        this.roiReportRepository = roiReportRepository;
    }

    @Override
    public List<RoiReport> getReportsForInfluencer(Long influencerId) {
        return roiReportRepository.findByInfluencer_Id(influencerId);
    }

    @Override
    public List<RoiReport> getReportsForCampaign(Long campaignId) {
        return roiReportRepository.findByCampaign_Id(campaignId);
    }
}
