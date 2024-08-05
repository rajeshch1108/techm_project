package com.MobileRecharge.Recharge.services;



import com.MobileRecharge.Recharge.dao.PlanDao;
import com.MobileRecharge.Recharge.dao.RechargeDao;
import com.MobileRecharge.Recharge.dao.UserDao;

import com.MobileRecharge.Recharge.models.Plan;
import com.MobileRecharge.Recharge.models.Recharge;
import com.MobileRecharge.Recharge.models.RechargeRequest;
import com.MobileRecharge.Recharge.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RechargeService {

    @Autowired
 RechargeDao rechargedao;
    @Autowired
    UserDao userdao;
    @Autowired
    PlanDao plandao;

    public Recharge createRecharge(Recharge recharge) {
        return rechargedao.save(recharge);
    }

    public List<Recharge> getRechargesExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate threeDaysLater = today.plusDays(3);

        return rechargedao.findByRechargeDateBetween(today, threeDaysLater);
    }

    public List<Recharge> getRechargesByUserId(Long userId) {
        return rechargedao.findByUser(new User(userId, null, null, null));
    }

    public List<User> findExpiringSubscribers() {
        LocalDate today = LocalDate.now();
        LocalDate threeDaysLater = today.plusDays(3);
        List<Recharge> expiringRecharges = rechargedao.findByRechargeDateBetween(today, threeDaysLater);
        List<User> expiringSubscribers = expiringRecharges.stream()
                .map(Recharge::getUser)
                .distinct()
                .toList();
        return expiringSubscribers;
    }

    public List<Recharge> findRechargeHistoryByUserId(Long userId) {
        User userOpt = userdao.findById(userId).get();
        if (userOpt.isPresent()) {
            return rechargedao.findByUser(userOpt);
        }
        return List.of();    }

    public User validateMobileNumber(String mobileNumber) {
        return userdao.findByMobileNumber(mobileNumber);
    }

    public List<Plan> getAvailablePlans() {
        return plandao.findAll();
    }

    public String processRecharge(RechargeRequest rechargeRequest) {
        Optional<User> userOpt = userdao.findById(rechargeRequest.getUserId());
        Optional<Plan> planOpt = plandao.findById(rechargeRequest.getPlanId());

        if (userOpt.isPresent() && planOpt.isPresent()) {
            User user = userOpt.get();
            Plan plan = planOpt.get();

            Recharge recharge = new Recharge(user, plan, LocalDate.now(), rechargeRequest.getPaymentMode());
            rechargedao.save(recharge);

            // Simulate sending a confirmation email
            // emailService.sendConfirmationEmail(user.getEmail(), recharge);

            return "Recharge successful";
        }

        return "Invalid user or plan";
    }
}

