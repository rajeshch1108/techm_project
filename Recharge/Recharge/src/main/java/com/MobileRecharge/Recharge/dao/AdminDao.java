package com.MobileRecharge.Recharge.dao;

import com.MobileRecharge.Recharge.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<Admin,String> {
}
