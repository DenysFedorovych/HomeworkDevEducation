package com.github.logger;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.Random;

public class RandomNumberApplication {

    private static final Logger log = Logger.getLogger(RandomNumberApplication.class);

    public RandomNumberApplication() {
        BasicConfigurator.configure();
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        try {
            if (randomNumber > 4) {
                log.info("Application run success.");
            } else {
                throw new LoggerException("Generated number is " + randomNumber);
            }
        } catch (LoggerException e) {
            log.log(Level.WARN,e.getMessage(),e);
        }
    }

    public static void main(String[] args) {
        RandomNumberApplication rna = new RandomNumberApplication();
    }
}
