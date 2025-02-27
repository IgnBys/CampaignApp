package com.futurum.technology.CampaignApp.entity;

import java.util.List;

public class Campaign {
    private String campaignName;
    private List<String> keywords;
    private double bidAmount;
    private double campaignFund;
    private boolean status;
    private List<String> town;
    private int radius;

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }

    public double getCampaignFund() {
        return campaignFund;
    }

    public void setCampaignFund(double campaignFund) {
        this.campaignFund = campaignFund;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<String> getTown() {
        return town;
    }

    public void setTown(List<String> town) {
        this.town = town;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
