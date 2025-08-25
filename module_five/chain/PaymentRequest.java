package ru.module_five.chain;

import java.math.BigDecimal;

public class PaymentRequest {
    public final BigDecimal amount;
    public final String purpose;
    public PaymentRequest(BigDecimal amount, String purpose) {
        this.amount = amount; this.purpose = purpose;
    }
}
