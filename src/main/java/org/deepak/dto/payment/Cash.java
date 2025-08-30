package org.deepak.dto.payment;

import org.deepak.enums.PaymentStatus;

import java.time.LocalDateTime;
import java.util.logging.Logger;

public class Cash extends Payment{
    private static final Logger logger = Logger.getLogger(Cash.class.getName());
    
    @Override
    public boolean initiatePayment(int amount) {
        if (amount <= 0) {
            return false;
        }
        logger.info("Processing cash payment of Rs " + amount);
        this.status = PaymentStatus.COMPLETED;
        this.timestamp = LocalDateTime.now();
        return true;
    }
}
