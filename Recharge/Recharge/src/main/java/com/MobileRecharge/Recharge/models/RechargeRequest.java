package com.MobileRecharge.Recharge.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
@Entity
@Data
public class RechargeRequest {
    @Id
    private Long userId;

    private Long planId;
    private String paymentMode;

    public RechargeRequest() {}

    public RechargeRequest(Long userId, Long planId, String paymentMode) {
        this.userId = userId;
        this.planId = planId;
        this.paymentMode = paymentMode;
    }
}
