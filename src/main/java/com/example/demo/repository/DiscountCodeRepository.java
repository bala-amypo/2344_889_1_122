package com.example.demo.repository;

import com.example.demo.entity.DiscountCode;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DiscountCodeRepository extends JpaRepository<DiscountCode, Long> {
    List<DiscountCode> findByInfluencerId(Long influencerId);
    List<DiscountCode> findByCampaignId(Long campaignId);
}
