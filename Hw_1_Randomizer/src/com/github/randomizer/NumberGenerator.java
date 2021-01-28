package com.github.randomizer;

import java.util.HashSet;
import java.util.Random;

public class NumberGenerator {
    private static Random random = new Random();
    private static HashSet set = new HashSet<Integer>();

    public static void generate(int max, int min) {
        if (set.size() == (max - min + 1)) {
            System.out.println("No more numbers available, goodbye!");
            System.exit(0);
        }
        int generated;
        do {
            generated = random.nextInt(max - min + 1) + min;
        }
        while (!set.add(generated));
        System.out.println("Here is your number : " + generated);
    }
}
