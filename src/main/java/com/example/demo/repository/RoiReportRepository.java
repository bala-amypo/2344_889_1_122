package com.example.demo.repository;

import com.example.demo.entity.RoiReport;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoiReportRepository extends JpaRepository<RoiReport, Long> {

    List<RoiReport> findByDiscountCode_Influencer_Id(Long influencerId);

    List<RoiReport> findByDiscountCode_Campaign_Id(Long campaignId);
}