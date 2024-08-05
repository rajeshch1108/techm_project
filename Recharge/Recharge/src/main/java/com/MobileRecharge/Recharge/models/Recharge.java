package com.MobileRecharge.Recharge.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@NoArgsConstructor
@Entity
@Data
public class Recharge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;



    @ManyToOne
    private Plan plan;
    private LocalDate rechargeDate;
    private String paymentMode;
    public Recharge(User user, Plan plan, LocalDate rechargeDate, String paymentMode) {
        this.user = user;
        this.plan = plan;
        this.rechargeDate = rechargeDate;
        this.paymentMode = paymentMode;
    }

}
