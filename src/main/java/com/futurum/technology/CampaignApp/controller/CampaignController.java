package com.futurum.technology.CampaignApp.controller;

import com.futurum.technology.CampaignApp.entity.Campaign;
import com.futurum.technology.CampaignApp.service.CampaignService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/campaigns")
public class CampaignController {
    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @GetMapping
    public List<Campaign> getAllCampaigns(){
        return campaignService.getAllCampaigns();
    }

    @GetMapping("/{id}")
    public Optional<Campaign> getCampaign(@PathVariable Long id){
        return campaignService.getCampaign(id);
    }

    @PostMapping()
    public Campaign createCampaign(@RequestBody Campaign campaign){
        return campaignService.createCampaign(campaign);
    }

    @PutMapping("/{id}")
    public Campaign updateCampaign(@PathVariable Long id, @RequestBody Campaign campaign){
        return campaignService.updateCampaign(id, campaign);
    }

    @DeleteMapping("/{id}")
    public void deleteCampaign(@PathVariable Long id){
        campaignService.deleteCampaign(id);
    }
}
