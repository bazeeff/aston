package ru.module_one.task_two.transport;

import ru.module_one.task_two.parts.*;

/** Грузовик — имеет колеса и возит грузы. */
public class Truck extends Vehicle implements HasWheels, CarriesCargo {
    private final Wheels wheels; private final Cargo cargo;
    public Truck(Wheels wheels, Cargo cargo) {
        super("Truck");
        this.wheels=wheels;
        this.cargo=cargo;
    }

    @Override
    public void start() {
        System.out.println("Грузовик едет");
    }

    @Override public void stop() {
        System.out.println("Грузовик остановился");
    }

    @Override public Wheels getWheels() {
        return wheels;
    }

    @Override
    public Cargo getCargo() {
        return cargo;
    }
}
