package com.github.oop;

public class ProcessorARM extends Processor{

    public ProcessorARM(double frequency, double cache, int bitCapacity) {
        super("ARM", frequency, cache, bitCapacity);
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
