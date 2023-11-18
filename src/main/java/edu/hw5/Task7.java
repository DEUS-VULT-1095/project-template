package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task7 {

    private Task7() {
    }

    public static boolean isValid1(String inputString) {
        return inputString.matches("[01]{2}0[01]*");
    }

    public static boolean isValid2(String inputString) {
        char firstCharacter = inputString.charAt(0);
        if (firstCharacter != '0' && firstCharacter != '1') {
            return false;
        }
        Pattern pattern = Pattern.compile("^" + Pattern.quote(String.valueOf(firstCharacter))
            + "[01]{0,}" + Pattern.quote(String.valueOf(firstCharacter)) + "$");
        Matcher matcher = pattern.matcher(inputString);
        return matcher.matches();
    }

    public static boolean isValid3(String inputString) {
        return inputString.matches("[01]{1,3}");
    }
}
