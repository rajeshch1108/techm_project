package com.MobileRecharge.Recharge.dao;

import com.MobileRecharge.Recharge.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Long> {
    User findByMobileNumber(String mobileNumber);

//    List<User> findSubscribersWithPlansExpiringBy(LocalDate threeDaysLater);
}
