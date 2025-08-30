package org.deepak.dto.payment;

import org.deepak.enums.PaymentStatus;

import java.time.LocalDateTime;
import java.util.logging.Logger;

public class CreditCard extends Payment{
    private static final Logger logger = Logger.getLogger(CreditCard.class.getName());
    private final String cardNumber;
    private final int cvv;

    public CreditCard(String cardNumber, int cvv) {
        if (cardNumber == null || cardNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Card number cannot be null or empty");
        }
        if (cvv < 100 || cvv > 9999) {
            throw new IllegalArgumentException("CVV must be 3 or 4 digits");
        }
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }
    
    @Override
    public boolean initiatePayment(int amount) {
        if (amount <= 0) {
            return false;
        }
        logger.info("Processing credit card payment of Rs " + amount);
        this.status = PaymentStatus.COMPLETED;
        this.timestamp = LocalDateTime.now();
        return true;
    }
}
