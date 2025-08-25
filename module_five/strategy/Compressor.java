package ru.module_five.strategy;

public class Compressor {
    private CompressionStrategy strategy;
    public Compressor(CompressionStrategy strategy) { this.strategy = strategy; }
    public void setStrategy(CompressionStrategy strategy) { this.strategy = strategy; }
    public byte[] compress(byte[] data) { return strategy.compress(data); }
    public String strategyName() { return strategy.name(); }
}
