package ru.module_five;

import ru.module_five.strategy.*;
import ru.module_five.chain.*;
import ru.module_five.builder.*;
import ru.module_five.proxy.*;
import ru.module_five.decorator.*;
import ru.module_five.adapter.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 1) Стратегия (Strategy) ===");
        demoStrategy();

        System.out.println("\n=== 2) Цепочка обязанностей (Chain of Responsibility) ===");
        demoChain();

        System.out.println("\n=== 3) Билдер (Builder) ===");
        demoBuilder();

        System.out.println("\n=== 4) Прокси (Proxy) ===");
        demoProxy();

        System.out.println("\n=== 5) Декоратор (Decorator) ===");
        demoDecorator();

        System.out.println("\n=== 6) Адаптер (Adapter) ===");
        demoAdapter();
    }

    static void demoStrategy() {
        byte[] data = "Hello Strategy Pattern!!!".getBytes();
        Compressor compressor = new Compressor(new ZipStrategy());
        byte[] out1 = compressor.compress(data);
        System.out.printf("Стратегия: %s, вход=%d, выход=%d%n",
                compressor.strategyName(), data.length, out1.length);

        compressor.setStrategy(new GzipStrategy());
        byte[] out2 = compressor.compress(data);
        System.out.printf("Стратегия: %s, вход=%d, выход=%d%n",
                compressor.strategyName(), data.length, out2.length);
    }

    static void demoChain() {
        Approver chain = new Manager();
        chain.linkWith(new Director()).linkWith(new CEO());

        chain.approve(new PaymentRequest(new BigDecimal("500"), "Канцтовары"));
        chain.approve(new PaymentRequest(new BigDecimal("7000"), "Командировки"));
        chain.approve(new PaymentRequest(new BigDecimal("25000"), "Новые сервера"));
    }

    static void demoBuilder() {
        UserAccount user = new UserAccountBuilder()
                .id(UUID.randomUUID())
                .email("jane.doe@example.com")
                .firstName("Jane")
                .lastName("Doe")
                .birthDate(LocalDate.of(1995, 3, 14))
                .phone("+31201234567")
                .newsletter(true)
                .addRole("USER").addRole("ADMIN")
                .build();
        System.out.println(user);
    }

    static void demoProxy() {
        Image img = new LazyImageProxy("diagram.png");
        img.display(); // первая загрузка — реально создаёт RealImage
        img.display(); // повторное — без загрузки
    }

    static void demoDecorator() {
        Notifier notifier =
                new SlackDecorator(
                        new SMSDecorator(
                                new EmailNotifier("ops@example.com"),
                                "+31600000000"
                        ),
                        "alerts"
                );
        notifier.send("CPU > 90% на prod-1");
    }

    static void demoAdapter() {
        PaymentGateway gateway = new EuroToRubPaymentAdapter();
        gateway.payEuro(new BigDecimal("12.34"), "Оплата подписки");
    }
}
