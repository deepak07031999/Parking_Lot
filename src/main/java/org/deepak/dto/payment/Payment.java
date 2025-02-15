package org.deepak.dto.payment;

import org.deepak.enums.PaymentStatus;

import java.time.LocalDateTime;

public abstract class Payment {
    protected PaymentStatus status;
    protected LocalDateTime timestamp;
    public abstract boolean initiatePayment(int amount);

    public Payment() {
        this.status = PaymentStatus.UNPAID;
    }
}
