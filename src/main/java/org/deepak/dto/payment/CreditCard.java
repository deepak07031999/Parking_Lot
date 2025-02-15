package org.deepak.dto.payment;

import org.deepak.enums.PaymentStatus;

import java.time.LocalDateTime;

public class CreditCard extends Payment{
    private final String cardNumber;
    private final int cvv;

    public CreditCard(String cardNumber, int cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }
    @Override
    public boolean initiatePayment(int amount) {
        System.out.println("making payment by CC of Rs " + amount);
        this.status = PaymentStatus.COMPLETED;
        this.timestamp = LocalDateTime.now();
        return true;
    }
}
