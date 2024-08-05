package com.MobileRecharge.Recharge.dao;

import com.MobileRecharge.Recharge.models.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlanDao extends JpaRepository<Plan, Long> {
    List<Plan> findByCategory(String category);
}
