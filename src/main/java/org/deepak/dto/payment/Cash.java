package org.deepak.dto.payment;

import org.deepak.enums.PaymentStatus;

import java.time.LocalDateTime;

public class Cash  extends Payment{
    @Override
    public boolean initiatePayment(int amount) {
        System.out.println("making payment by cash of Rs " + amount);
        this.status = PaymentStatus.COMPLETED;
        this.timestamp = LocalDateTime.now();
        return true;
    }
}
