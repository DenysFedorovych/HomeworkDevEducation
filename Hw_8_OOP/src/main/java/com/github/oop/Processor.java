package com.github.oop;

public abstract class Processor {
    public final String architecture;

    private double frequency;
    private double cache;
    private int bitCapacity;

    public Processor(String architecture, double frequency, double cache, int bitCapacity) {
        this.architecture = architecture;
        this.frequency = frequency;
        this.cache = cache;
        this.bitCapacity = bitCapacity;
    }

    public String getDetails() {
        return frequency + " " + cache + " " + bitCapacity;
    }

    public abstract String dataProcess(String data);

    public abstract String dataProcess(long data);

    @Override
    public String toString() {
        return "Processor{" +
                "architecture='" + architecture + '\'' +
                ", frequency=" + frequency +
                ", cache=" + cache +
                ", bitCapacity=" + bitCapacity +
                '}';
    }
}
