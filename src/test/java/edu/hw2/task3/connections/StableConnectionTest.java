package edu.hw2.task3.connections;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class StableConnectionTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void beforeEach() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void afterEach() {
        System.setOut(System.out);
    }

    @Test
    void execute() throws Exception {
        // Arrange
        try (StableConnection stableConnection = new StableConnection()) {

            String command = "your_command";
            String expectedOutput = "Executing command on a stable connection: " + command;

            // Act
            stableConnection.execute(command);

            // Assert
            assertEquals(expectedOutput, outContent.toString());
        }
    }

}
