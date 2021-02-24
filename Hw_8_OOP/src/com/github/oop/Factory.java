package com.github.oop;

import java.util.Arrays;

public class Factory {
    public static void sortByArchitecture(Device[] arr){
        Arrays.sort(arr, DeviceComparator.comparatorArchitecture());
    }

    public static void sortByProcessor(Device[] arr){
        Arrays.sort(arr, DeviceComparator.comparatorProcessor());
    }

    public static void sortByMemorySize(Device[] arr){
        Arrays.sort(arr, DeviceComparator.comparatorMemorySize());
    }

    public static void sortByMemoryUsed(Device[] arr){
        Arrays.sort(arr, DeviceComparator.comparatorMemoryUsed());
    }

    public static void toString(Device[] arr){
        for(Device each : arr){
            if(each == null) continue;
            System.out.println(each.getSystemInfo());
        }
    }

    public static void main(String[] args) {
        Processor x86 = new ProcessorX86(1.4,1000,1000);
        ProcessorARM arm = new ProcessorARM(1.2,12,23);
        ProcessorX86 x861 = new ProcessorX86(2.1,10000,1024);
        Memory memory1 = new Memory(5);
        String[] arr = {"1","2","3","4","5"};
        Device[] devices = new Device[10];
        Device a1 = new Device(new Memory(5),new ProcessorX86(1.4,20,2000));
        Device a2 = new Device(new Memory(7),new ProcessorARM(1.0,10,200));
        Device a3 = new Device(new Memory(8),new ProcessorARM(0.4,15,100));
        Device a4 = new Device(new Memory(arr),new ProcessorX86(0.7,30,2040));
        Device a5 = new Device(new Memory(9),new ProcessorX86(0.8,230,400));
        Device a6 = new Device(new Memory(arr),new ProcessorX86(1.9,100,1000));
        Device a7 = new Device(new Memory(arr),new ProcessorARM(1.2,140,1200));
        Device a8 = new Device(new Memory(arr),new ProcessorX86(2.1,300,1400));
        Device a9 = new Device(new Memory(10),new ProcessorARM(4.0,400,5200));
        Device a10 = new Device(new Memory(arr),new ProcessorX86(3.5,12,6500));
        devices[0] = a1;
        devices[1] = a2;
        devices[2] = a3;
        devices[3] = a4;
        devices[4] = a5;
        devices[5] = a6;
        devices[6] = a7;
        devices[7] = a8;
        devices[8] = a9;
        devices[9] = a10;
        sortByProcessor(devices);
        toString(devices);
    }
}
