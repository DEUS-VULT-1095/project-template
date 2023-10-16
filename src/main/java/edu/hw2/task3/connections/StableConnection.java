package edu.hw2.task3.connections;


public class StableConnection implements Connection {
    @SuppressWarnings("RegexpSinglelineJava")
    @Override
    public void execute(String command) {
        System.out.println("Executing command on a stable connection: " + command);
    }

    @SuppressWarnings("RegexpSinglelineJava")
    @Override
    public void close() throws Exception {
        System.out.println("Closing stable connection...");
    }
}
