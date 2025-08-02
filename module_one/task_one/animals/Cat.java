package ru.module_one.task_one.animals;

import ru.module_one.task_one.environment.Fur;

/**
 * Кошка — млекопитающее, живёт на суше, имеет шерсть.
 */
public class Cat extends Mammal implements Terrestrial, HasFur {
    private final Fur fur;

    public Cat(Fur fur) { this.fur = fur; }

    @Override
    public void eat() {
        System.out.println("Кошка ест мясо и рыбу");
    }

    @Override
    public void move() {
        System.out.println("Кошка идет по земле");
    }

    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public void feedMilk() {
        System.out.println("Кошка кормит котят молоком");
    }

    @Override
    public String getTerrain() {
        return "На суше, где угодно";
    }

    @Override
    public Fur getFur() {
        return fur; }
}
