package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task6 {

    private Task6() {
    }

    public static boolean isSubsequence(String inputString, String patternString) {
        StringBuilder regex = new StringBuilder();
        for (int i = 0; i < patternString.length(); i++) {
            char nextChar = patternString.charAt(i);
            regex.append(".*" + Pattern.quote(String.valueOf(nextChar)) + "+");
        }
        regex.append(".*");
        Pattern pattern = Pattern.compile(regex.toString());
        Matcher matcher = pattern.matcher(inputString);
        return matcher.find();
    }
}
