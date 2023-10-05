package edu.hw1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// task0
public class HelloWorld {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorld.class);

    public static void logGreeting() {
        LOGGER.info("Hello, World!");
    }

    public static void main(String[] args) {
        logGreeting();
    }
}
