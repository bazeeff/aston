package ru.module_five.strategy;

public class ZipStrategy implements CompressionStrategy {
    @Override public byte[] compress(byte[] data) {
        byte[] out = new byte[(data.length + 1) / 2];
        for (int i = 0, j = 0; i < data.length; i += 2, j++) out[j] = data[i];
        return out;
    }
    @Override public String name() { return "ZIP"; }
}
