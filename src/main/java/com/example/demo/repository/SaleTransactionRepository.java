package com.example.demo.repository;

import com.example.demo.entity.SaleTransaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleTransactionRepository extends JpaRepository<SaleTransaction, Long> {

    List<SaleTransaction> findByDiscountCode_Id(Long discountCodeId);

    List<SaleTransaction> findByDiscountCode_Influencer_Id(Long influencerId);

    List<SaleTransaction> findByDiscountCode_Campaign_Id(Long campaignId);
}