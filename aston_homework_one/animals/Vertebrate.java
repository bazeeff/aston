package ru.aston_homework_one.animals;

/**
 * Все позвоночные животные.
 */
public abstract class Vertebrate implements Animal {
    private final boolean hasBackbone = true;

    public boolean hasBackbone() {
        return hasBackbone;
    }
}
