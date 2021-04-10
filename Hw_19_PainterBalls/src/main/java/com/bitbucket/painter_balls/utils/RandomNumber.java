package com.bitbucket.painter_balls.utils;

import java.awt.*;
import java.util.Random;

public class RandomNumber {

    private static final Random random = new Random();

    public static int getRandomDiameter(){
        return random.nextInt(100);
    }

    public static Color getRandomColor(){
        return new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
    }

    public static short getRandomVelocity(){
        return (short) (random.nextInt(30) - 15);
    }

}
