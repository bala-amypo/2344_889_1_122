package com.example.demo.service;

import com.example.demo.entity.RoiReport;
import java.util.List;

public interface RoiReportService {

    RoiReport generateReportForCode(Long discountCodeId);

    RoiReport getReportById(Long reportId);

    List<RoiReport> getReportsForInfluencer(Long influencerId);

    List<RoiReport> getReportsForCampaign(Long campaignId);

    void deleteReport(Long reportId);
}
