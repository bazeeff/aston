package ru.aston_homework_one.environment;

/**
 * Вода — среда обитания водных животных.
 */
public class Water {
    private double depth;    // глубина водоёма
    private String type;     // река, озеро, море, океан

    public Water(double depth, String type) {
        this.depth = depth;
        this.type = type;
    }

    public double getDepth() {
        return depth;
    }

    public String getType() {
        return type;
    }
}
