package ru.module_five.decorator;

public class SMSDecorator extends NotifierDecorator {
    private final String phone;
    public SMSDecorator(Notifier wrappee, String phone) {
        super(wrappee); this.phone = phone;
    }
    @Override public void send(String message) {
        wrappee.send(message);
        System.out.printf("SMS -> %s: %s%n", phone, message);
    }
}
