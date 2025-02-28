package com.futurum.technology.CampaignApp.service;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Getter
@Service
public class EmeraldService {
    private BigDecimal emeraldBalance = new BigDecimal(5000);

    public boolean deductEmeraldBalance(BigDecimal amount) {
        if (emeraldBalance.compareTo(amount) >= 0) {
            emeraldBalance = emeraldBalance.subtract(amount);
            return false;
        }
        return true;
    }

    public void addEmeraldBalance(BigDecimal amount) {
        emeraldBalance = emeraldBalance.add(amount);
    }
}
