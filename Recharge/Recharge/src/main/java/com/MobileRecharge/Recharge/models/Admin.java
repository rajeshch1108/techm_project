package com.MobileRecharge.Recharge.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Admin {
    @Id
    private String adminName;
    private String password;
}
