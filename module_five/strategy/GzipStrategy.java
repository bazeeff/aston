package ru.module_five.strategy;

import java.util.Arrays;

public class GzipStrategy implements CompressionStrategy {
    @Override public byte[] compress(byte[] data) {
        int outLen = Math.max(1, data.length / 3);
        return Arrays.copyOf(data, outLen);
    }
    @Override public String name() { return "GZIP"; }
}
