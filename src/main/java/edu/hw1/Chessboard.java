package edu.hw1;

// task8
public class Chessboard {

    public static boolean knightBoardCapture(int[][] array) {
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    if (array[i][j] != 0) {
                        if ((j + 2) < array[0].length) {
                            if ((i + 1) < array.length) {
                                if (array[i + 1][j + 2] != 0) return false;
                            }
                            if ((i - 1) > 0) {
                                if (array[i - 1][j + 2] != 0) return false;
                            }
                        }
                    }
                }
            }
            array = rotateArray(array);
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
}
