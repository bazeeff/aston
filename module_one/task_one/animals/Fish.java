package ru.module_one.task_one.animals;

import ru.module_one.task_one.environment.Water;

/**
 * Рыба — позвоночное, живёт в воде.
 */
public class Fish extends Vertebrate implements Aquatic {
    private final Water habitat;

    public Fish(Water habitat) { this.habitat = habitat; }

    @Override
    public void eat() {
        System.out.println("Рыба ест планктон и других рыб");
    }

    @Override
    public void move() {
        System.out.println("Рыба плавает в воде");
    }

    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public Water getHabitat() {
        return habitat;
    }
}
