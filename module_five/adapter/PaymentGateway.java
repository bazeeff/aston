package ru.module_five.adapter;

import java.math.BigDecimal;

public interface PaymentGateway { void payEuro(BigDecimal euros, String description); }
