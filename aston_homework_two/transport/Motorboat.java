package ru.aston_homework_two.transport;

import ru.aston_homework_two.parts.*;

/** Катер — имеет винт. */
public class Motorboat extends Vehicle implements HasPropeller {
    private final Propeller propeller;

    public Motorboat(Propeller propeller) {
        super("Катер");
        this.propeller=propeller;
    }

    @Override
    public void start() {
        System.out.println("Катер плывет");
    }

    @Override public void stop() {
        System.out.println("Катер остановился");
    }

    @Override public Propeller getPropeller() {
        return propeller;
    }
}
