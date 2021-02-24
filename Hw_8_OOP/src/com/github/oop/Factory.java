package com.github.oop;

public class Factory {
    public static void main(String[] args) {
        Processor x86 = new ProcessorX86(1.4,1000,1000);
        ProcessorARM arm = new ProcessorARM();
        ProcessorX86 x861 = new ProcessorX86(2.1,10000,1024);
        Memory memory1 = new Memory(5);

    }
}
