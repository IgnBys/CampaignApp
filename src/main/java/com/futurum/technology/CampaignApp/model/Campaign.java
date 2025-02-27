package com.futurum.technology.CampaignApp.model;

import jakarta.persistence.*;

@Entity
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String campaignName;

    @Column(nullable = false)
    private String keywords;

    @Column(nullable = false)
    private Double bidAmount;

    @Column(nullable = false)
    private Double campaignFund;

    @Column(nullable = false)
    private Boolean status;

    @Column(nullable = false)
    private String town;

    @Column(nullable = false)
    private Integer radius;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(Double bidAmount) {
        this.bidAmount = bidAmount;
    }

    public Double getCampaignFund() {
        return campaignFund;
    }

    public void setCampaignFund(Double campaignFund) {
        this.campaignFund = campaignFund;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }
}