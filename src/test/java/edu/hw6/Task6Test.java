package edu.hw6;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task6Test {

    @Test
    void testGetBusyPorts() {
        // Arrange
        int expectedTCPCount = 0;
        int expectedUDPCount = 0;

        for (int i = 0; i < 49151; i++) {
            try (ServerSocket serverSocket = new ServerSocket(i)) {
            } catch (IOException ex) {
                expectedTCPCount++;
            }

            try (DatagramSocket datagramSocket = new DatagramSocket(i)) {
            } catch (IOException ex) {
                expectedUDPCount++;
            }
        }

        // Act
        String actualString = Task6.getBusyPorts();
        String[] linesArray = actualString.split("\n");
        int actualTCPCount = (int) Arrays.stream(linesArray).filter(l -> l.startsWith("TCP")).count();
        int actualUDPCount = (int) Arrays.stream(linesArray).filter(l -> l.startsWith("UDP")).count();

        // Assert
        assertEquals(expectedTCPCount, actualTCPCount);
        assertEquals(expectedUDPCount, actualUDPCount);
        assertEquals(expectedTCPCount + expectedUDPCount, linesArray.length - 1);
    }
}
