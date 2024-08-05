package com.MobileRecharge.Recharge.controllers;
import com.MobileRecharge.Recharge.models.Plan;
import com.MobileRecharge.Recharge.models.Recharge;
import com.MobileRecharge.Recharge.models.RechargeRequest;
import com.MobileRecharge.Recharge.models.User;
import com.MobileRecharge.Recharge.services.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.Flow;

@RestController

@RequestMapping("recharges")
public class RechargeController {

    @Autowired
    private RechargeService rechargeService;

    @GetMapping("/expiring")
    public List<User> getExpiringSubscribers() {
        return rechargeService.findExpiringSubscribers();
    }

    @GetMapping("/history/{userId}")
    public List<Recharge> getRechargeHistory(@PathVariable Long userId) {
        return rechargeService.findRechargeHistoryByUserId(userId);
    }

    @GetMapping("/validate/{mobileNumber}")
    public User validateMobileNumber(@PathVariable String mobileNumber) {
        return rechargeService.validateMobileNumber(mobileNumber);
    }

    @GetMapping("/plans")
    public List<Plan> getAvailablePlans() {
        return rechargeService.getAvailablePlans();
    }

    @PostMapping("/process")
    public String processRecharge(@RequestBody RechargeRequest recharge) {
        return rechargeService.processRecharge(recharge);
    }
}