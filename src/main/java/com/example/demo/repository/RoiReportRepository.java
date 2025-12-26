package com.example.demo.repository;

import com.example.demo.entity.RoiReport;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoiReportRepository
        extends JpaRepository<RoiReport, Long> {

    List<RoiReport> findByDiscountCode_Influencer_Id(Long influencerId);

    List<RoiReport> findByDiscountCode_Campaign_Id(Long campaignId);
}
