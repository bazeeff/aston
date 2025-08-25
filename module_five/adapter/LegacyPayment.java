package ru.module_five.adapter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LegacyPayment {
    public void payRubles(int kopecks, String purpose) {
        System.out.printf("Legacy: оплата %s RUB (копеек: %d) — %s%n",
                kopecksToRub(kopecks), kopecks, purpose);
    }
    private static String kopecksToRub(int k) {
        BigDecimal rub = new BigDecimal(k).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
        return rub.toPlainString();
    }
}
