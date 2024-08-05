package com.MobileRecharge.Recharge.services;

import com.MobileRecharge.Recharge.dao.AdminDao;
import com.MobileRecharge.Recharge.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminDao dao;

    public ResponseEntity<String> adminLogin(String adminName, String password) {
        Admin admin = dao.findById(adminName).get();
        if (admin.getPassword().equals(password)) {

            return new ResponseEntity<>("login success", HttpStatus.OK);
        }
        return new ResponseEntity<>("login failed",HttpStatus.BAD_REQUEST);
    }
}
