package ru.module_five.adapter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EuroToRubPaymentAdapter implements PaymentGateway {
    private static final BigDecimal EUR_TO_RUB = new BigDecimal("100.00"); // демо-курс
    private final LegacyPayment legacy = new LegacyPayment();

    @Override public void payEuro(BigDecimal euros, String description) {
        BigDecimal rub = euros.multiply(EUR_TO_RUB);                 // EUR -> RUB
        int kopecks = rub.multiply(new BigDecimal(100)).setScale(0, RoundingMode.HALF_UP).intValueExact();
        legacy.payRubles(kopecks, "[через адаптер] " + description);
    }
}
