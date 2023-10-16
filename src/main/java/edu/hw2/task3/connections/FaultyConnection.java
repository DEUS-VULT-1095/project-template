package edu.hw2.task3.connections;

import edu.hw2.task3.exceptions.ConnectionException;
import java.util.Random;

public class FaultyConnection implements Connection {
    @SuppressWarnings("RegexpSinglelineJava")
    @Override
    public void execute(String command) {
        Random random = new Random();
        if (random.nextBoolean()) {
            throw new ConnectionException();
        }
        System.out.println("Executing command on a faulty connection: " + command);
    }

    @SuppressWarnings("RegexpSinglelineJava")
    @Override
    public void close() throws Exception {
        System.out.println("Closing faulty connection...");
    }
}
