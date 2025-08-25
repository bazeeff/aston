package ru.module_five.chain;

import java.math.BigDecimal;

public class Director extends Approver {
    protected boolean canApprove(PaymentRequest r) { return r.amount.compareTo(new BigDecimal("10000")) <= 0; }
    protected String role() { return "Директор"; }
}
