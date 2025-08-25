package ru.module_five.decorator;

public abstract class NotifierDecorator implements Notifier {
    protected final Notifier wrappee;
    protected NotifierDecorator(Notifier wrappee) { this.wrappee = wrappee; }
}
