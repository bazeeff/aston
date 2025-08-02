package ru.module_one.task_one.animals;

/**
 * Все позвоночные животные.
 */
public abstract class Vertebrate implements Animal {
    private final boolean hasBackbone = true;

    public boolean hasBackbone() {
        return hasBackbone;
    }
}
