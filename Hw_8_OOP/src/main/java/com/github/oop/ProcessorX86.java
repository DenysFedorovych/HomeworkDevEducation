package com.github.oop;

public class ProcessorX86 extends Processor{

    public ProcessorX86(double frequency, double cache, int bitCapacity) {
        super("X86",frequency, cache, bitCapacity);
    }

    @Override
    public String dataProcess(String data) {
        return "Data Process in PROCESSOR X86 with String";
    }

    public String getArchitecture() {
        return architecture;
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
