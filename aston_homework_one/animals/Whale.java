package ru.aston_homework_one.animals;

import ru.aston_homework_one.environment.Water;

/**
 * Кит — млекопитающее, живёт в воде.
 */
public class Whale extends Mammal implements Aquatic {
    private final Water habitat;

    public Whale(Water habitat) {
        this.habitat = habitat;
    }

    @Override
    public void eat() {
        System.out.println("Кит ест планктон");
    }

    @Override
    public void move() {
        System.out.println("Кит плавает");
    }

    @Override
    public boolean isAlive() {
        return true; }

    @Override
    public void feedMilk() {
        System.out.println("Кит кормит молоком");
    }

    @Override
    public Water getHabitat() {
        return habitat;
    }
}
