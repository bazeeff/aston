package ru.module_one.task_one.environment;

/**
 * Шерсть — свойство млекопитающих.
 */
public class Fur {
    private String color;    // цвет
    private double length;   // в сантиметрах

    public Fur(String color, double length) {
        this.color = color;
        this.length = length;
    }

    public String getColor() {
        return color;
    }

    public double getLength() {
        return length;
    }
}
