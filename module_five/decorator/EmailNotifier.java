package ru.module_five.decorator;

public class EmailNotifier implements Notifier {
    private final String email;
    public EmailNotifier(String email) { this.email = email; }
    @Override public void send(String message) {
        System.out.printf("Email -> %s: %s%n", email, message);
    }
}
