package com.MobileRecharge.Recharge.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String mobileNumber;
    private String password;

    public User(Long userId, String name, String mobileNumber, String password) {
        this.userId = userId;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.password = password;
    }


    public boolean isPresent() {
        return true;
    }
}
