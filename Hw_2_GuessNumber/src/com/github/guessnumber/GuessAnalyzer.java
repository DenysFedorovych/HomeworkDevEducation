package com.github.guessnumber;

public class GuessAnalyzer {
    private int min, max, number, last_distance, tries, counter = 0;

    public GuessAnalyzer(int min, int max, int number, int tries) {
        this.min = min;
        this.max = max;
        this.number = number;
        this.tries = tries;
    }

    private void isGoal(int number) {
        if (number == this.number) {
            System.out.println("Поздравляю! Ты угадал число за " + counter + " попыток!");
            System.exit(0);
        }
    }

    private boolean validates(int current) {
        if (current > max || current < min) {
            System.out.println("Число не в диапазоне");
            return false;
        } else return true;
    }

    private boolean isCloser(int current) {
        int distance = Math.abs(current - number);
        return distance < last_distance;
    }

    private void analyzeDistance(int current) {
        int distance = Math.abs(current - number);
        if (counter != 1) {
            if (last_distance > distance) System.out.println("Теплее, но все еще не то!)");
            else {
                System.out.println("Теплее не стало, пробуй снова(");
            }
        } else System.out.println("Нет, это не то число");
        last_distance = distance;
    }

    public void guess(int current) {
        if (!validates(current)) return;
        counter++;
        isGoal(current);
        analyzeDistance(current);
        if (counter == tries) {
            System.out.println("Попытки кончились, пока");
            System.exit(0);
        }
    }
}
