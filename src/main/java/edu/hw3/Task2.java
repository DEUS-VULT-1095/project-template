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

        if (providedString.length() % 2 != 0) {
            throw new RuntimeException("Brackets are out of balance");
        }

        List<String> clusterList = new ArrayList<>();
        int leftBracketCount = 0;
        int rightBracketCount = 0;
        StringBuilder sb = new StringBuilder();

        for (char next: providedString.toCharArray()) {
            sb.append(next);

            if (String.valueOf(next).equals("(")) {
                leftBracketCount++;
            } else if (String.valueOf(next).equals(")")) {
                rightBracketCount++;
            } else {
                throw new RuntimeException("String must contain only '(' and ')'");
            }

            if (leftBracketCount == rightBracketCount) {
                clusterList.add(sb.toString());
                sb = new StringBuilder();
            }
        }

        return clusterList;
    }
}
