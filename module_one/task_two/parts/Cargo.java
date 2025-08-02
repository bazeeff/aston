package ru.module_one.task_two.parts;

/**
 * Грузовая часть — позволяет перевозить грузы.
 */
public class Cargo {
    private double capacity;

    public Cargo(double capacity) {
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }
}
