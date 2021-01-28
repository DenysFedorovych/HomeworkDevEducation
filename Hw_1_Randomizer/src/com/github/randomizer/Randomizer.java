package com.github.randomizer;

public class Randomizer {
    private final int min;
    private final int max;

    public Randomizer(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public void help() {
        System.out.println("Write 'generate' to generate unique number between your max and min bounds");
        System.out.println("Write 'exit' to exit this randomizer");
        System.out.println("Write 'help' to see all allowed commands (but you`re already here (ಠ_ಠ) )");
    }

    public void executeCommand() {
        String line = NumberScanner.getCommand();
        switch (line) {
            case ("generate"):
                NumberGenerator.generate(max, min);
                break;
            case ("exit"):
                System.exit(0);
            case ("help"):
                help();
                break;
            default:
                System.out.println("Undefined command, try something else");
                break;
        }
    }

    public static void main(String[] args) {
        System.out.println("I`m your today`s Randomizer. At first, we need to set our bounds");
        int min = NumberScanner.getMin();
        int max = NumberScanner.getMax();
        Randomizer main = new Randomizer(min, max);
        System.out.println("Now you are free to do anything! (Write 'help' for help)");
        while (true) {
            main.executeCommand();
        }
    }
}

