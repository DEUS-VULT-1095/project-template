package edu.project2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class MySolverTest {
    private Solver solver = new MySolver();


    @ParameterizedTest
    @MethodSource
    void testGetPath_whenProvidedInvalidParameters_thrownRuntimeException(int startY, int startX, int endY, int endX,
        Cell[][] maze) {
        // Arrange
        String expectedMessage = "Incorrect input parameters";

        // Act && Assert
        RuntimeException exception = assertThrows(RuntimeException.class,
            () -> solver.getPath(startY, startX, endY, endX, maze), "Incorrect exception type");

        // Assert
        assertEquals(expectedMessage, exception.getMessage(), "Incorrect exception message");
    }

    private static Stream<Arguments> testGetPath_whenProvidedInvalidParameters_thrownRuntimeException() {
        return Stream.of(
            Arguments.of(-1, 0, 10, 10, new Cell[11][11]),
            Arguments.of(0, -1, 10, 10, new Cell[11][11]),
            Arguments.of(0, 0, 12, 10, new Cell[11][11]),
            Arguments.of(0, 0, 10, 12, new Cell[11][11])
        );
    }

    @Test
    void testGetPath_whenProvidedValidParameters_returnCorrectArray() throws CloneNotSupportedException {
        // Arrange
        Cell zeroZero = new Cell(0, 0);
        zeroZero.setRightBorder(false);
        Cell zeroOne = new Cell(0, 1);
        zeroOne.setDownBorder(false);
        Cell oneOne = new Cell(1, 1);
        Cell oneZero = new Cell(1, 0);
        oneZero.setRightBorder(false);
        Cell[][] maze = {
            new Cell[]{zeroZero, zeroOne},
            new Cell[]{oneZero, oneOne}
        };
        int startY = 0;
        int startX = 0;
        int endY = 1;
        int endX = 0;

        // Act
        Cell[][] actualMaze = solver.getPath(startY, startX, endY, endX, maze);

        // Assert
        assertTrue(actualMaze[0][0].isSolve());
        assertTrue(actualMaze[0][1].isSolve());
        assertTrue(actualMaze[1][1].isSolve());
        assertTrue(actualMaze[1][0].isSolve());
    }
}
