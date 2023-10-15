package edu.hw1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// task0
public final class HelloWorld {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorld.class);

    private HelloWorld() {
    }

    public static void logGreeting() {
        LOGGER.info("Hello, World!");
    }
}
