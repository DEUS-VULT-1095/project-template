package edu.hw3;

import java.util.ArrayList;
import java.util.List;

public final class Task2 {
    private Task2() {
    }

    public static List<String> clusterize(String providedString) {
        if (!providedString.contains("(") || !providedString.contains(")")) {
            throw new RuntimeException("String not contain '(' and ')'");
        }

        List<String> clusterList = new ArrayList<>();
        int leftBracketCount = 0;
        int rightBracketCount = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < providedString.length(); i++) {
            char nextChar = providedString.charAt(i);
            sb.append(nextChar);

            if (String.valueOf(nextChar).equals("(") && i != (providedString.length() - 1)) {
                leftBracketCount++;
            } else if (String.valueOf(nextChar).equals(")") && i != 0) {
                rightBracketCount++;
            } else if (!String.valueOf(nextChar).equals("(") && !String.valueOf(nextChar).equals(")")) {
                throw new RuntimeException("String must contain only '(' and ')'");
            }

            if (leftBracketCount == rightBracketCount) {
                clusterList.add(sb.toString());
                sb = new StringBuilder();
            }

            if ((i == (providedString.length() - 1) && leftBracketCount != rightBracketCount)
                || (leftBracketCount == 0 && rightBracketCount == 0)) {
                throw new RuntimeException("Incorrect construction of brackets");
            }
        }

        return clusterList;
    }
}
