package edu.hw1;

// task7
public final class CyclicBitShift {
    private static final String ERROR_MESSAGE = "Incorrect data provided for right rotate";

    private CyclicBitShift() {
    }

    public static int rotateRight(int n, int shift) {
        if (n < 0 || shift < 0) {
            throw new RuntimeException(ERROR_MESSAGE);
        }

        int position = -1;
        int mold = n;

        while (mold != 0) {
            mold >>= 1;
            position++;
        }

        mold = n;
        int flag = 1 << position;

        for (int i = 0; i < shift; i++) {
            if (mold % 2 != 0) {
                mold >>= 1;
                mold = mold | flag;
            } else {
                mold >>= 1;
            }
        }
        return mold;
    }

    public static int rotateLeft(int n, int shift) {
        if (n < 0 || shift < 0) {
            throw new RuntimeException(ERROR_MESSAGE);
        }

        int position = 0;
        int mold = n;

        while (mold != 0) {
            mold >>= 1;
            position++;
        }

        mold = n;
        int flag = ~(1 << position);

        for (int i = 0; i < shift; i++) {
            mold <<= 1;
            if (mold > n) {
                mold = (mold & flag) + 1;
            }
        }

        return mold;
    }

    public static int rotateRightVersionTwo(int n, int shift) {
        if (n < 0 || shift < 0) {
            throw new RuntimeException(ERROR_MESSAGE);
        }

        String binaryString = Integer.toBinaryString(n);

        for (int i = 0; i < shift; i++) {
            binaryString = binaryString.charAt(binaryString.length() - 1)
                + binaryString.substring(0, binaryString.length() - 1);
        }

        return Integer.parseInt(binaryString, 2);
    }

    public static int rotateLeftVersionTwo(int n, int shift) {
        if (n < 0 || shift < 0) {
            throw new RuntimeException(ERROR_MESSAGE);
        }

        String binaryString = Integer.toBinaryString(n);

        for (int i = 0; i < shift; i++) {
            binaryString = binaryString.substring(1) + binaryString.charAt(0);
        }

        return Integer.parseInt(binaryString, 2);
    }
}
