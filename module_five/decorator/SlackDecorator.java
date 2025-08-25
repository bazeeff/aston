package ru.module_five.decorator;

public class SlackDecorator extends NotifierDecorator {
    private final String channel;
    public SlackDecorator(Notifier wrappee, String channel) {
        super(wrappee); this.channel = channel;
    }
    @Override public void send(String message) {
        wrappee.send(message);
        System.out.printf("Slack #%s: %s%n", channel, message);
    }
}
