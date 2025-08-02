package ru.module_one.task_two.transport;

import ru.module_one.task_two.parts.*;

/** Танкер — имеет винт и возит грузы. */
public class Tanker extends Vehicle implements HasPropeller, CarriesCargo {
    private final Propeller propeller;
    private final Cargo cargo;

    public Tanker(Propeller propeller, Cargo cargo) {
        super("Tanker");
        this.propeller=propeller;
        this.cargo=cargo;
    }

    @Override
    public void start() {
        System.out.println("Танкер плывет");
    }

    @Override
    public void stop() {
        System.out.println("Танкер остановился");
    }

    @Override
    public Propeller getPropeller() {
        return propeller;
    }

    @Override
    public Cargo getCargo() {
        return cargo;
    }
}
