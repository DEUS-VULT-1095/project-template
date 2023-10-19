package edu.hw2.task3.connection_managers;

import edu.hw2.task3.connections.Connection;
import edu.hw2.task3.connections.FaultyConnection;
import edu.hw2.task3.connections.StableConnection;
import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    @Override
    public Connection getConnection() {
        Random random = new Random();
        if (random.nextBoolean()) {
            return new FaultyConnection();
        }
        return new StableConnection();
    }
}
