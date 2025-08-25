package ru.module_five.chain;

import java.math.BigDecimal;

public class CEO extends Approver {
    protected boolean canApprove(PaymentRequest r) { return r.amount.compareTo(new BigDecimal("1000000")) <= 0; }
    protected String role() { return "CEO"; }
}
