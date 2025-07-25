package ru.aston_homework_two.transport;

/** Базовый класс всех транспортных средств. */
public abstract class Vehicle implements Transport {

    private final String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
