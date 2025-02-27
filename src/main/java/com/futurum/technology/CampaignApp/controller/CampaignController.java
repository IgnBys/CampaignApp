package com.futurum.technology.CampaignApp.controller;

import com.futurum.technology.CampaignApp.model.Campaign;
import com.futurum.technology.CampaignApp.service.CampaignService;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.OK)
    public List<Campaign> getAllCampaigns(){
        return campaignService.getAllCampaigns();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Campaign> getCampaign(@PathVariable Long id){
       return campaignService.getCampaign(id);

    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Campaign createCampaign(@RequestBody Campaign campaign){
        return campaignService.createCampaign(campaign);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Campaign updateCampaign(@PathVariable Long id, @RequestBody Campaign campaign){
        return campaignService.updateCampaign(id, campaign);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCampaign(@PathVariable Long id){
        campaignService.deleteCampaign(id);
    }
}
