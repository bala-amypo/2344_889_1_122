package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "campaigns")
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String campaignName;
    
    private LocalDate startDate;
    
    private LocalDate endDate;
    
    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL)
    private List<DiscountCode> discountCodes;
    
    public Campaign() {}
    
    public Campaign(String campaignName, LocalDate startDate, LocalDate endDate) {
        this.campaignName = campaignName;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public static CampaignBuilder builder() {
        return new CampaignBuilder();
    }
    
    public static class CampaignBuilder {
        private Long id;
        private String campaignName;
        private LocalDate startDate;
        private LocalDate endDate;
        private List<DiscountCode> discountCodes;
        
        public CampaignBuilder id(Long id) { this.id = id; return this; }
        public CampaignBuilder campaignName(String campaignName) { this.campaignName = campaignName; return this; }
        public CampaignBuilder startDate(LocalDate startDate) { this.startDate = startDate; return this; }
        public CampaignBuilder endDate(LocalDate endDate) { this.endDate = endDate; return this; }
        public CampaignBuilder discountCodes(List<DiscountCode> discountCodes) { this.discountCodes = discountCodes; return this; }
        
        public Campaign build() {
            Campaign campaign = new Campaign();
            campaign.id = this.id;
            campaign.campaignName = this.campaignName;
            campaign.startDate = this.startDate;
            campaign.endDate = this.endDate;
            campaign.discountCodes = this.discountCodes;
            return campaign;
        }
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getCampaignName() { return campaignName; }
    public void setCampaignName(String campaignName) { this.campaignName = campaignName; }
    
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    
    public List<DiscountCode> getDiscountCodes() { return discountCodes; }
    public void setDiscountCodes(List<DiscountCode> discountCodes) { this.discountCodes = discountCodes; }
}
