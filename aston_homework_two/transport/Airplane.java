package ru.aston_homework_two.transport;

import ru.aston_homework_two.parts.*;

/** Самолет — имеет крылья, винт и колеса. */
public class Airplane extends Vehicle implements HasWheels, HasPropeller, HasWings {
    private final Wheels wheels;
    private final Propeller propeller;
    private final Wings wings;

    public Airplane(Wheels wheels, Propeller propeller, Wings wings) {
        super("Самолет");
        this.wheels=wheels;
        this.propeller=propeller;
        this.wings=wings;
    }

    @Override
    public void start() {
        System.out.println("Самолет взлетает");
    }

    @Override
    public void stop() {
        System.out.println("Самолет приземляется");
    }

    @Override
    public Wheels getWheels() {
        return wheels;
    }

    @Override
    public Propeller getPropeller() {
        return propeller;
    }

    @Override
    public Wings getWings() {
        return wings;
    }
}
