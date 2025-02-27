package com.futurum.technology.CampaignApp.service;

import com.futurum.technology.CampaignApp.entity.Campaign;
import com.futurum.technology.CampaignApp.repository.CampaignRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignService {

    private final CampaignRepository campaignRepository;

    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    public List<Campaign> getAllCampaigns(){
        return campaignRepository.findAll();
    }
    public Optional<Campaign> getCampaign(Long id){
        return campaignRepository.findById(id);
    }

    public Campaign createCampaign(Campaign campaign){
        return campaignRepository.save(campaign);
    }

    public Campaign updateCampaign(Long id, Campaign newCampaign){
        Campaign campaign = campaignRepository.findById(id).orElse(null);
        if(campaign != null){
            campaign.setCampaignName(newCampaign.getCampaignName());
            campaign.setKeywords(newCampaign.getKeywords());
            campaign.setBidAmount(newCampaign.getBidAmount());
            campaign.setCampaignFund(newCampaign.getCampaignFund());
            campaign.setStatus(newCampaign.getStatus());
            campaign.setTown(newCampaign.getTown());
            campaign.setRadius(newCampaign.getRadius());
            return campaignRepository.save(campaign);
        }
        return null;
    }

    public void deleteCampaign(Long id){
        campaignRepository.deleteById(id);
    }
}
