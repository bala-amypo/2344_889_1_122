package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.entity.DiscountCode;
import com.example.demo.entity.RoiReport;
import com.example.demo.entity.SaleTransaction;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.repository.RoiReportRepository;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.RoiReportService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RoiReportServiceImpl implements RoiReportService {

    private final RoiReportRepository roiReportRepository;
    private final SaleTransactionRepository saleTransactionRepository;
    private final DiscountCodeRepository discountCodeRepository;

    public RoiReportServiceImpl(
            RoiReportRepository roiReportRepository,
            SaleTransactionRepository saleTransactionRepository,
            DiscountCodeRepository discountCodeRepository) {
        this.roiReportRepository = roiReportRepository;
        this.saleTransactionRepository = saleTransactionRepository;
        this.discountCodeRepository = discountCodeRepository;
    }

    @Override
    public RoiReport generateReportForCode(Long discountCodeId) {

        DiscountCode code = discountCodeRepository.findById(discountCodeId)
                .orElseThrow(() -> new ResourceNotFoundException("Discount code not found"));

        List<SaleTransaction> sales =
                saleTransactionRepository.findByDiscountCode_Id(discountCodeId);

        BigDecimal totalSales = BigDecimal.ZERO;
        for (SaleTransaction sale : sales) {
            totalSales = totalSales.add(sale.getTransactionAmount());
        }

        int totalTransactions = sales.size();
        Double roiPercentage = totalTransactions > 0 ? 10.0 : 0.0;

        RoiReport report = new RoiReport(
                code,
                totalSales,
                totalTransactions,
                roiPercentage
        );

        return roiReportRepository.save(report);
    }

    @Override
    public RoiReport getReportById(Long reportId) {
        return roiReportRepository.findById(reportId)
                .orElseThrow(() -> new ResourceNotFoundException("ROI report not found"));
    }

    @Override
    public List<RoiReport> getReportsForInfluencer(Long influencerId) {
        return roiReportRepository.findByDiscountCode_Influencer_Id(influencerId);
    }

    @Override
    public List<RoiReport> getReportsForCampaign(Long campaignId) {
        return roiReportRepository.findByDiscountCode_Campaign_Id(campaignId);
    }

    @Override
    public void deleteReport(Long reportId) {
        if (!roiReportRepository.existsById(reportId)) {
            throw new ResourceNotFoundException("ROI report not found");
        }
        roiReportRepository.deleteById(reportId);
    }
}
