package edu.hw2.task4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @Test
    void testCallingInfo() {
        // Arrange
        Class expectedClass = Task4.CallingInfo.class;

        // Act
        Object actualInstance = Task4.callingInfo();

        // Assert
        assertEquals(expectedClass, actualInstance.getClass());
    }
}
