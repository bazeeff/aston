package ru.module_five.chain;

import java.math.BigDecimal;

public class Manager extends Approver {
    protected boolean canApprove(PaymentRequest r) { return r.amount.compareTo(new BigDecimal("1000")) <= 0; }
    protected String role() { return "Менеджер"; }
}
