package com.github.guessnumber;

public class GuessNumber {

    public static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        int min = LocalScanner.getMin();
        int max = LocalScanner.getMax();
        int tries = LocalScanner.getTries();
        System.out.println("Привет, я загадал число от " + min + " до " + max + " из вашего диапазона. Попробуй угадать его за " + tries + " попыток!");
        GuessAnalyzer guessAnalyzer = new GuessAnalyzer(min,max,RandomNumber.generateRandom(min,max),tries);
        while (true) {
            String s = LocalScanner.getString();
            if (s.equals("exit")) System.exit(0);
            if (isDigit(s)) guessAnalyzer.guess(Integer.parseInt(s));
        }
    }
}

