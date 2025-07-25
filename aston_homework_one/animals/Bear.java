package ru.aston_homework_one.animals;

import ru.aston_homework_one.environment.Fur;

/**
 * Медведь — млекопитающее, живёт на суше, имеет шерсть.
 */
public class Bear extends Mammal implements Terrestrial, HasFur {
    private final Fur fur;

    public Bear(Fur fur) {
        this.fur = fur;
    }

    @Override
    public void eat() {
        System.out.println("Медведь ест ягоды и рыбу");
    }

    @Override
    public void move() {
        System.out.println("Медведь идет по земле");
    }

    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public void feedMilk() {
        System.out.println("Медведица кормит медвежат молоком");
    }

    @Override
    public String getTerrain() {
        return "На суше в лесу";
    }

    @Override
    public Fur getFur() {
        return fur;
    }
}
