package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "discount_codes")
public class DiscountCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String codeValue;

    private Double discountPercentage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "influencer_id")
    
    private Influencer influencer;   

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;       

    @OneToMany(mappedBy = "discountCode", fetch = FetchType.LAZY)
    private List<SaleTransaction> saleTransactions;
    private Boolean active;

    


   



    public DiscountCode() {
    }

    public DiscountCode(String codeValue, Double discountPercentage) {
        this.codeValue = codeValue;
        this.discountPercentage = discountPercentage;
    }

    public Long getId() {
        return id;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public Influencer getInfluencer() {
        return influencer;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public List<SaleTransaction> getSaleTransactions() {
        return saleTransactions;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public void setInfluencer(Influencer influencer) {
        this.influencer = influencer;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public void setSaleTransactions(List<SaleTransaction> saleTransactions) {
        this.saleTransactions = saleTransactions;
    }
    public boolean isActive() {
    return active;
}

public void setActive(boolean active) {
    this.active = active;
}
}