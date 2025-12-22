package com.example.demo.service;

import com.example.demo.entity.RoiReport;
import java.util.List;

public interface RoiReportService {

    RoiReport createReport(RoiReport report);

    RoiReport getReportById(Long id);

    List<RoiReport> getAllReports();

    RoiReport updateReport(Long id, RoiReport report);

    void deleteReport(Long id);
}
