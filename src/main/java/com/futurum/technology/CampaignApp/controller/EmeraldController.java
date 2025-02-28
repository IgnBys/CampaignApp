package com.futurum.technology.CampaignApp.controller;

import com.futurum.technology.CampaignApp.service.EmeraldService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/emerald-balance")
@CrossOrigin("http://localhost:3000")

public class EmeraldController {
    private final EmeraldService emeraldService;

    public EmeraldController(EmeraldService emeraldService) {
        this.emeraldService = emeraldService;
    }

    @GetMapping("")
    public BigDecimal getEmeraldBalance() {
        return emeraldService.getEmeraldBalance();
    }
}
