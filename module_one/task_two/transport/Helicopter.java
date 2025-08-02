package ru.module_one.task_two.transport;

import ru.module_one.task_two.parts.*;

/** Вертолет — имеет винт и колеса. */
public class Helicopter extends Vehicle implements HasPropeller, HasWheels {
    private final Propeller propeller; private final Wheels wheels;
    public Helicopter(Propeller propeller, Wheels wheels) {
        super("Вертолет");
        this.propeller=propeller;
        this.wheels=wheels;
    }

    @Override
    public void start() {
        System.out.println("Вертолет взлетает");
    }

    @Override
    public void stop() {
        System.out.println("Вертолет приземляется");
    }

    @Override
    public Propeller getPropeller() {
        return propeller;
    }

    @Override
    public Wheels getWheels() {
        return wheels;
    }

}
