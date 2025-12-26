package com.example.demo.service;

import com.example.demo.entity.RoiReport;
import java.util.List;

public interface RoiService {
    RoiReport generateReportForCode(Long discountCodeId);
    RoiReport getReportById(Long reportId);
    List<RoiReport> getReportsForInfluencer(Long influencerId);
}
