package ru.module_one.task_two;

import ru.module_one.task_two.parts.*;
import ru.module_one.task_two.transport.*;

public class Main {
    public static void main(String[] args) {
        Wheels wheels4 = new Wheels(4);
        Propeller prop = new Propeller(1.5);
        Wings wings = new Wings(15.0);
        Cargo cargo = new Cargo(20.0);

        Vehicle airplane = new Airplane(wheels4, prop, wings);
        Vehicle truck = new Truck(wheels4, cargo);
        Vehicle taxi = new Taxi(wheels4);

        System.out.println(airplane.getName() + " размах крыльев: " + ((HasWings)airplane).getWings().getSpan());
        System.out.println("Грузоподъемность грузовика: " + ((CarriesCargo)truck).getCargo().getCapacity());
        System.out.println("Количество колес у такси: " + ((HasWheels)taxi).getWheels().getCount());
    }
}
