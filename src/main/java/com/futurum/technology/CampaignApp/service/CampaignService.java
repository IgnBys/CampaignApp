package com.futurum.technology.CampaignApp.service;

import com.futurum.technology.CampaignApp.model.Campaign;
import com.futurum.technology.CampaignApp.repository.CampaignRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignService {

    private final CampaignRepository campaignRepository;
    private final EmeraldService emeraldService;

    public CampaignService(CampaignRepository campaignRepository, EmeraldService emeraldService) {
        this.campaignRepository = campaignRepository;
        this.emeraldService = emeraldService;
    }

    public List<Campaign> getAllCampaigns(){
        return campaignRepository.findAll();
    }
    public Optional<Campaign> getCampaign(Long id){
        return campaignRepository.findById(id);
    }

    public Campaign createCampaign(Campaign campaign){
        if(!emeraldService.deductEmeraldBalance(campaign.getCampaignFund())){
            throw new RuntimeException("Insufficient emerald funds.");
        }
        return campaignRepository.save(campaign);
    }

    public Campaign updateCampaign(Long id, Campaign newCampaign){
        Campaign campaign = campaignRepository.findById(id).orElse(null);
        if(campaign != null){
            BigDecimal oldFund = campaign.getCampaignFund();
            BigDecimal newFund = newCampaign.getCampaignFund();
            BigDecimal fundDifference = newFund.subtract(oldFund);
            if (fundDifference.compareTo(BigDecimal.ZERO) > 0) {
                if (!emeraldService.deductEmeraldBalance(fundDifference)) {
                    throw new RuntimeException("Not enough funds on your Emerald balance!");
                }
            }
            else if (fundDifference.compareTo(BigDecimal.ZERO) < 0) {
                emeraldService.addEmeraldBalance(fundDifference.abs());
            }
            campaign.setCampaignName(newCampaign.getCampaignName());
            campaign.setKeywords(newCampaign.getKeywords());
            campaign.setBidAmount(newCampaign.getBidAmount());
            campaign.setCampaignFund(newCampaign.getCampaignFund());
            campaign.setStatus(newCampaign.getStatus());
            campaign.setTown(newCampaign.getTown());
            campaign.setRadius(newCampaign.getRadius());
            return campaignRepository.save(campaign);
        }else {
            throw new RuntimeException("Campaign wasn't found");
        }
    }

    public void deleteCampaign(Long id){
        campaignRepository.findById(id).ifPresent(campaign -> emeraldService.addEmeraldBalance(campaign.getCampaignFund()));
        campaignRepository.deleteById(id);
    }
}
