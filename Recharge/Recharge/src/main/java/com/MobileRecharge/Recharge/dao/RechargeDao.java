package com.MobileRecharge.Recharge.dao;

import com.MobileRecharge.Recharge.models.Recharge;
import com.MobileRecharge.Recharge.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
//public interface RechargeDao extends JpaRepository<Recharge, Long> {
//    List<Recharge> findByUser(Long id);
//
//
//    //    @Query("SELECT r FROM Recharge r WHERE r.rechargeDate >= CURRENT_DATE AND r.rechargeDate < CURRENT_DATE + 3")
////    List<Recharge> findRechargesExpiringSoon();
//}
public interface RechargeDao extends JpaRepository<Recharge, Long> {
    List<Recharge> findByUser(User user);

    List<Recharge> findByRechargeDateBetween(LocalDate startDate, LocalDate endDate);
}
