package com.github.oop;

import java.util.Comparator;

public class DeviceComparator {
    public static Comparator<Device> comparatorArchitecture() {
        return new Comparator<Device>() {
            @Override
            public int compare(Device o1, Device o2) {
                if(o1 == o2) return 0;
                if(o1 == null) return -1;
                if(o2 == null) return 1;
                return o1.processor.architecture.compareTo(o2.processor.architecture);
            }
        };
    }

    public static Comparator<Device> comparatorProcessor() {
        return new Comparator<Device>() {
            @Override
            public int compare(Device o1, Device o2) {
                if(o1 == o2) return 0;
                if(o1 == null) return -1;
                if(o2 == null) return 1;
                return o1.processor.getDetails().compareTo(o2.processor.getDetails());
            }
        };
    }

    public static Comparator<Device> comparatorMemorySize() {
        return new Comparator<Device>() {
            @Override
            public int compare(Device o1, Device o2) {
                if(o1 == o2) return 0;
                if(o1 == null) return -1;
                if(o2 == null) return 1;
                int m1 = Integer.parseInt(o1.memory.getMemoryInfo().split(" ")[0]);
                int m2 = Integer.parseInt(o2.memory.getMemoryInfo().split(" ")[0]);
                return m1-m2;
            }
        };
    }

    public static Comparator<Device> comparatorMemoryUsed() {
        return new Comparator<Device>() {
            @Override
            public int compare(Device o1, Device o2) {
                if(o1 == o2) return 0;
                if(o1 == null) return -1;
                if(o2 == null) return 1;
                int m1 = Integer.parseInt(o1.memory.getMemoryInfo().split(" ")[1]);
                int m2 = Integer.parseInt(o2.memory.getMemoryInfo().split(" ")[1]);
                return m2-m1;
            }
        };
    }
}
