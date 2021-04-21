package com.github.guessnumber;

import java.util.Random;

public class RandomNumber {
    public static int generateRandom(int min, int max){
        Random random = new Random();
        return random.nextInt(max-min+1)+min;
    }
}
