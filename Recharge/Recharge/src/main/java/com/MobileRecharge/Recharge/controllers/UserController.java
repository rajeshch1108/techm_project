package com.MobileRecharge.Recharge.controllers;

import com.MobileRecharge.Recharge.models.*;
import com.MobileRecharge.Recharge.services.PlanService;
import com.MobileRecharge.Recharge.services.RechargeService;
import com.MobileRecharge.Recharge.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("User")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    PlanService planService;
    @Autowired
    RechargeService rechargeService;

//    Boolean isPresent=false;
    @PostMapping("login")
    public ResponseEntity<String> userLogin (@RequestBody UserWrapper uw){

        return userService.userLogin(uw.getId(),uw.getPassword());
    }
    @PostMapping("signup")
    public ResponseEntity<String> userSignup(@RequestBody User user){
        return userService.userSignup(user.getName(),user.getMobileNumber(),user.getPassword());
    }

    @GetMapping("/validate/{mobileNumber}")
    public ResponseEntity<String> validateUser(@PathVariable String mobileNumber) {
        User user = userService.validateUser(mobileNumber);
        return user.isPresent() ? ResponseEntity.ok("Valid user") : ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

    @GetMapping("/plans")
    public List<Plan> getAllPlans() {
        return planService.getAllPlans();
    }

    @GetMapping("/plans/{category}")
    public List<Plan> getPlansByCategory(@PathVariable String category) {
        return planService.getPlansByCategory(category);
    }

    @PostMapping("/recharge")
    public ResponseEntity<String> rechargeUser(@RequestBody RechargeRequest rechargeRequest){
        String recharge = rechargeService. processRecharge(rechargeRequest);
//        emailService.sendConfirmationEmail(recharge);
        return ResponseEntity.ok("Recharge successful");
    }
}
