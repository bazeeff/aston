package ru.module_five.proxy;

public class LazyImageProxy implements Image {
    private RealImage real;
    private final String filename;
    public LazyImageProxy(String filename) { this.filename = filename; }
    @Override public void display() {
        if (real == null) {
            System.out.println("Прокси: отложенная инициализация...");
            real = new RealImage(filename);
        } else {
            System.out.println("Прокси: использую кэшированный объект");
        }
        real.display();
    }
}
