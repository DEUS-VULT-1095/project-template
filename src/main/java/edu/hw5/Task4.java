package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task4 {

    private Task4() {
    }

    public static boolean isStrongPassword(String password) {
        Pattern pattern = Pattern.compile(".*[~!@#$%^&*|].*");
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }
}
