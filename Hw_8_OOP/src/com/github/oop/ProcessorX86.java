package com.github.oop;

public class ProcessorX86 extends Processor{

    private final String architecture = "X86";

    public ProcessorX86(double frequency, double cache, int bitCapacity) {
        super(frequency, cache, bitCapacity);
    }

    public ProcessorX86() {
    }

    @Override
    public String dataProcess(String data) {
        return "Data Process in PROCESSOR X86 with String";
    }

    @Override
    public String dataProcess(long data) {
        return "Data Process in PROCESSOR X86 with long";
    }

    @Override
    public String toString() {
        return "ProcessorX86{" +
                "architecture='" + architecture + '\'' +
                getDetails() +
                '}';
    }
}
