package edu.hw1;

// task8
public final class Chessboard {
    private static final int ROTATIONS_NUMBER = 4;
    private static final int[][] MOVES = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {1, -2}, {-1, 2}, {1, 2}};


    private Chessboard() {
    }

    public static boolean knightBoardCapture(int[][] array) {
        int[][] validationArray = array;

        for (int k = 0; k < ROTATIONS_NUMBER; k++) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    if (array[i][j] != 0) {
                        if ((j + 2) < array[0].length && (i + 1) < array.length) {
                            if (array[i + 1][j + 2] != 0) {
                                return false;
                            }
                        }
                        if ((j + 2) < array[0].length && (i - 1) > 0) {
                            if (array[i - 1][j + 2] != 0) {
                                return false;
                            }
                        }
                    }
                }
            }
            validationArray = rotateArray(validationArray);
        }

        return true;
    }

    private static int[][] rotateArray(int[][] originalArray) {
        int[][] rotatedArray = new int[originalArray[0].length][originalArray.length];

        for (int i = 0; i < originalArray.length; i++) {
            for (int j = 0; j < originalArray[0].length; j++) {
                rotatedArray[j][originalArray.length - 1 - i] = originalArray[i][j];
            }
        }

        return rotatedArray;
    }

    public static boolean knightBoardCaptureVersionTwo(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] != 0) {
                    for (int[] move : MOVES) {
                        int x = j + move[1];
                        int y = i + move[0];

                        if (x >= 0 && x < array[0].length && y >= 0 && y < array.length && array[y][x] != 0) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
