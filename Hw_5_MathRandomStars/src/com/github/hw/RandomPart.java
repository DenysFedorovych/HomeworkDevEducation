package com.github.hw;

public class RandomPart {
    public static void randomNum() {
        System.out.println(RandomNum.randomInt());
    }

    public static void randomTenNum() {
        for (byte i = 0; i < 10; i++) {
            System.out.println(RandomNum.randomInt());
        }
    }

    public static void randomTenNum(int left_border, int right_border) {
        for (byte i = 0; i < 10; i++) {
            System.out.println(RandomNum.randomInt(left_border, right_border));
        }
    }

    public static void randomNumOfRandomNums() {
        int counter = RandomNum.randomInt(3, 15);
        for (int i = 0; i < counter; i++) {
            System.out.println(RandomNum.randomInt(-10, 35));
        }
    }

}
