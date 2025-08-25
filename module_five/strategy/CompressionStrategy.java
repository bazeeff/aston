package ru.module_five.strategy;

public interface CompressionStrategy {
    byte[] compress(byte[] data);
    String name();
}
