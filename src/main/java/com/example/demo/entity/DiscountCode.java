package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "discount_codes")
public class DiscountCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String codeValue;
    
    private Double discountPercentage;
    
    @ManyToOne
    @JoinColumn(name = "influencer_id")
    private Influencer influencer;
    
    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;
    
    @OneToMany(mappedBy = "discountCode", cascade = CascadeType.ALL)
    private List<SaleTransaction> saleTransactions;
    
    @OneToMany(mappedBy = "discountCode", cascade = CascadeType.ALL)
    private List<RoiReport> roiReports;
    
    public DiscountCode() {}
    
    public DiscountCode(String codeValue, Double discountPercentage) {
        this.codeValue = codeValue;
        this.discountPercentage = discountPercentage;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getCodeValue() { return codeValue; }
    public void setCodeValue(String codeValue) { this.codeValue = codeValue; }
    
    public Double getDiscountPercentage() { return discountPercentage; }
    public void setDiscountPercentage(Double discountPercentage) { this.discountPercentage = discountPercentage; }
    
    public Influencer getInfluencer() { return influencer; }
    public void setInfluencer(Influencer influencer) { this.influencer = influencer; }
    
    public Campaign getCampaign() { return campaign; }
    public void setCampaign(Campaign campaign) { this.campaign = campaign; }
    
    public List<SaleTransaction> getSaleTransactions() { return saleTransactions; }
    public void setSaleTransactions(List<SaleTransaction> saleTransactions) { this.saleTransactions = saleTransactions; }
    
    public List<RoiReport> getRoiReports() { return roiReports; }
    public void setRoiReports(List<RoiReport> roiReports) { this.roiReports = roiReports; }
}
