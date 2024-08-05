package com.MobileRecharge.Recharge.controllers;

import com.MobileRecharge.Recharge.dao.PlanDao;
import com.MobileRecharge.Recharge.models.Plan;
import com.MobileRecharge.Recharge.services.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("plans")
public class PlanController {
    PlanDao plandao;
    @Autowired PlanService planService;
    public List<Plan> getAllPlans() {
        return plandao.findAll();
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Plan>> getPlansByCategory(@PathVariable String category) {
        List<Plan> plans = planService.getPlansByCategory(category);
        return ResponseEntity.ok(plans);
    }
}
