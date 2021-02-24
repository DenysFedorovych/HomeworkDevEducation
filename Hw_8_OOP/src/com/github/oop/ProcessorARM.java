package com.github.oop;

public class ProcessorARM extends Processor{

    private final String architecture = "ARM";

    public ProcessorARM(double frequency, double cache, int bitCapacity) {
        super(frequency, cache, bitCapacity);
    }

    public ProcessorARM() {
    }

    @Override
    public String dataProcess(String data) {
        return "Data Process in PROCESSOR ARM with String";
    }

    @Override
    public String dataProcess(long data) {
        return "Data Process in PROCESSOR ARM with long";
    }

    @Override
    public String toString() {
        return "ProcessorARM{" +
                "architecture='" + architecture + '\'' +
                getDetails() +
                '}';
    }
}
