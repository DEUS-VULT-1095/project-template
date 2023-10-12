package edu.hw1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class ChessboardTest {

    @ParameterizedTest
    @MethodSource("testKnightBoardCapture_WhenProvidedArrayWithTrueCondition")
    void testKnightBoardCapture_WhenProvidedArrayWithTrueCondition_ReturnsTrue(int[][] chessboard) {
        // Arrange

        // Act
        boolean isNotCross = Chessboard.knightBoardCapture(chessboard);

        // Assert
        assertTrue(isNotCross);
    }

    @ParameterizedTest
    @MethodSource("testKnightBoardCapture_WhenProvidedArrayWithFalseCondition")
    void testKnightBoardCapture_WhenProvidedArrayWithFalseCondition_ReturnsFalse(int[][] chessboard) {
        // Arrange

        // Act
        boolean isNotCross = Chessboard.knightBoardCapture(chessboard);

        // Assert
        assertFalse(isNotCross);
    }

    @ParameterizedTest
    @MethodSource("testKnightBoardCapture_WhenProvidedArrayWithTrueCondition")
    void testKnightBoardCaptureVersionTwo_WhenProvidedArrayWithTrueCondition_ReturnsTrue(int[][] chessboard) {
        // Arrange;

        // Act
        boolean isNotCross = Chessboard.knightBoardCaptureVersionTwo(chessboard);

        // Assert
        assertTrue(isNotCross);
    }

    @ParameterizedTest
    @MethodSource("testKnightBoardCapture_WhenProvidedArrayWithFalseCondition")
    void testKnightBoardCaptureVersionTwo_WhenProvidedArrayWithFalseCondition_ReturnsFalse(int[][] chessboard) {
        // Arrange

        // Act
        boolean isNotCross = Chessboard.knightBoardCaptureVersionTwo(chessboard);

        // Assert
        assertFalse(isNotCross);
    }

    private static Stream<Arguments> testKnightBoardCapture_WhenProvidedArrayWithTrueCondition() {
        return Stream.of(
            Arguments.of((Object) new int[][]
                {
                    {0, 0, 0, 1, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 1, 0, 0, 0, 1, 0, 0},
                    {0, 0, 0, 0, 1, 0, 1, 0},
                    {0, 1, 0, 0, 0, 1, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 1, 0, 0, 0, 0, 0, 1},
                    {0, 0, 0, 0, 1, 0, 0, 0}
                }
            ),
            Arguments.of((Object) new int[][]
                {
                    {1, 0, 0, 1, 0, 1, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 1, 1, 1, 1, 0},
                    {1, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 1},
                    {0, 1, 0, 0, 1, 0, 0, 0}
                })
        );
    }

    private static Stream<Arguments> testKnightBoardCapture_WhenProvidedArrayWithFalseCondition() {
        return Stream.of(
            Arguments.of((Object) new int[][]
                {
                    {1, 0, 1, 0, 1, 0, 1, 0},
                    {0, 1, 0, 1, 0, 1, 0, 1},
                    {0, 0, 0, 0, 1, 0, 1, 0},
                    {0, 0, 1, 0, 0, 1, 0, 1},
                    {1, 0, 0, 0, 1, 0, 1, 0},
                    {0, 0, 0, 0, 0, 1, 0, 1},
                    {1, 0, 0, 0, 1, 0, 1, 0},
                    {0, 0, 0, 1, 0, 1, 0, 1}
                }
            ),
            Arguments.of((Object) new int[][]
                {
                    {0, 0, 0, 0, 1, 0, 0, 0},
                    {0, 0, 0, 0, 0, 1, 0, 0},
                    {0, 0, 0, 1, 0, 0, 0, 0},
                    {1, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 1, 0, 0, 0},
                    {0, 0, 0, 0, 0, 1, 0, 0},
                    {0, 0, 0, 0, 0, 1, 0, 0},
                    {1, 0, 0, 0, 0, 0, 0, 0}
                }
            )
        );
    }
}
