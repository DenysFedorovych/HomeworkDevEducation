package com.github.oop;

import java.util.Arrays;

public class Memory {
    private String[] memoryCell = null;

    public Memory(String[] memoryCell) {
        this.memoryCell = memoryCell;
    }

    public Memory(int n) {
        String[] arr = new String[n];
        memoryCell = arr;
    }

    public String readLast() {
        return memoryCell[getLastIndex()];
    }

    public String removeLast(){

        int i = getLastIndex();
        if(i==-1) {return null;}
        String result = memoryCell[i];
        memoryCell[i] = null;
        return result;

    }

    public boolean save(String input) {

        int i = getLastIndex();
        if(i==-1) {return false;}
        if (i == memoryCell.length - 1) {
            return false;
        } else {
            memoryCell[i+1] = input;
            return true;
        }

    }

    public String getMemoryInfo(){
        return memoryCell.length + " " + getUsedMemory();
    }

    private int getLastIndex(){

        if(memoryCell == null) {return -1;}
        int i = 0;
        while (i < memoryCell.length - 1 && memoryCell[i + 1] != null) {
            i++;
        }
        return i;

    }

    private double getUsedMemory(){

        if(memoryCell == null) return 100.0;
        double i = getLastIndex()+1;
        double memory = memoryCell.length;
        return  i/memory*100.0;

    }

    @Override
    public String toString(){
        return Arrays.toString(memoryCell);
    }

}
