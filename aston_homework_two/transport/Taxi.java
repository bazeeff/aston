package ru.aston_homework_two.transport;

import ru.aston_homework_two.parts.*;

/** Такси — имеет колеса. */
public class Taxi extends Vehicle implements HasWheels {
    private final Wheels wheels;
    public Taxi(Wheels wheels) {
        super("Такси");
        this.wheels=wheels;
    }

    @Override public void start() {
        System.out.println("Такси едет и перевозит пассажиров");
    }

    @Override public void stop() {
        System.out.println("Такси остановилось");
    }

    @Override public Wheels getWheels() {
        return wheels;
    }
}
