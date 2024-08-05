package com.MobileRecharge.Recharge.controllers;

import com.MobileRecharge.Recharge.models.Admin;
import com.MobileRecharge.Recharge.models.Recharge;
import com.MobileRecharge.Recharge.models.User;
import com.MobileRecharge.Recharge.services.AdminService;
import com.MobileRecharge.Recharge.services.RechargeService;
import com.MobileRecharge.Recharge.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    RechargeService rechargeService;
    private UserService userService;


    @PostMapping("adminLogin")
    public ResponseEntity<String> adminLogin (@RequestBody Admin admin){
        return adminService.adminLogin(admin.getAdminName(),admin.getPassword());
    }


//    @GetMapping("/recharge-history/{userId}")
//    public List<Recharge> getRechargeHistory(@PathVariable Long userId) {
//        return rechargeService.findRechargeHistoryByUserId(userId);
//    }

    @GetMapping("/expiring-recharges")
    public List<Recharge> getExpiringRecharges() {
        return rechargeService.getRechargesExpiringSoon();
    }

    @GetMapping("/user-recharges/{userId}")
    public List<Recharge> getUserRecharges(@PathVariable Long userId) {
        return rechargeService.getRechargesByUserId(userId);
    }

    @GetMapping("/user/{userId}")
    public User getUserDetails(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }
    @GetMapping("expiringSubscribers")
    public List<User> findExpiringSubscribers(){
        return rechargeService.findExpiringSubscribers();
    }
}


