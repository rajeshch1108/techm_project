package com.MobileRecharge.Recharge.services;

import com.MobileRecharge.Recharge.dao.PlanDao;
import com.MobileRecharge.Recharge.models.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {
    @Autowired
    private PlanDao planDao;

    public List<Plan> getAllPlans() {
        return planDao.findAll();
    }

    public List<Plan> getPlansByCategory(String category) {
        return planDao.findByCategory(category);
    }
}






