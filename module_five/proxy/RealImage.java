package ru.module_five.proxy;

public class RealImage implements Image {
    private final String filename;
    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }
    private void loadFromDisk() {
        System.out.printf("Загрузка изображения '%s' с диска...%n", filename);
        try { Thread.sleep(400); } catch (InterruptedException ignored) {}
    }
    @Override public void display() {
        System.out.printf("Отображение изображения '%s'%n", filename);
    }
}
