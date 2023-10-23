package edu.hw3;

public final class Task1 {
    private static final int BEGINNING_UPPER_CASE = 65;
    private static final int END_UPPER_CASE = 90;
    private static final int BEGINNING_LOWER_CASE = 97;
    private static final int END_LOWER_CASE = 122;
    private static final int DIFFERENCE = 25;


    private Task1() {
    }

    public static String encode(String text) {
        StringBuilder sb = new StringBuilder();

        for (char next: text.toCharArray()) {
            char encodeChar = next;

            if ((next >= BEGINNING_UPPER_CASE && next <= END_UPPER_CASE)
                || (next >= BEGINNING_LOWER_CASE && next <= END_LOWER_CASE)) {

                int beginningValue;

                if (next <= END_UPPER_CASE) {
                    beginningValue = BEGINNING_UPPER_CASE;
                } else {
                    beginningValue = BEGINNING_LOWER_CASE;
                }

                encodeChar = (char) (next + DIFFERENCE - (next - beginningValue) * 2);
            }

            sb.append(encodeChar);
        }

        return sb.toString();
    }
}
