package com.github.oop;

public abstract class Processor {

    private double frequency;
    private double cache;
    private int bitCapacity;

    public Processor(double frequency, double cache, int bitCapacity) {
        this.frequency = frequency;
        this.cache = cache;
        this.bitCapacity = bitCapacity;
    }

    public Processor() {
    }

    public String getDetails() {
        return frequency + " " + cache + " " + bitCapacity;
    }

    public abstract String dataProcess(String data);

    public abstract String dataProcess(long data);
}
