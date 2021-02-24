package com.github.oop;

public class Device {
    private Memory memory;
    private Processor processor;

    public Device(Memory memory, Processor processor) {
        this.memory = memory;
        this.processor = processor;
    }

    public Device() {
    }

    public void save(String[] data) {
        int i = 0;
        while (!isMemoryFilled() && i < data.length - 1) {
            memory.save(data[i++]);
        }
    }

    public String[] readAll() {

        String[] result = new String[getNumberOfUsedCells()];
        for(int i=0; i < result.length; i++){
            result[i] = memory.removeLast();
        }
        return result;

    }

    public void dataProcessing(){
        String[] data = readAll();
        String[] result = new String[data.length];
        int i = 0;
        for(String each : data){
            result[i++] = processor.dataProcess(each);
        }
        save(result);
    }

    public String getSystemInfo(){
        return processor.toString() + memory.getMemoryInfo();
    }

    private boolean isMemoryFilled() {

        if (memory == null) return true;
        double percent = getPercentOfUsedMemory();
        return percent == 100.0;

    }

    private double getPercentOfUsedMemory() {
        return Double.parseDouble(memory.getMemoryInfo().split(" ")[1]);
    }

    private int getNumberOfUsedCells(){
        double numberOfMemory = Double.parseDouble(memory.getMemoryInfo().split(" ")[0]);
        return (int) (numberOfMemory*getPercentOfUsedMemory());
    }
}
