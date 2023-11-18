package edu.hw5;

public final class Task8 {

    private Task8() {
    }

    public static boolean isValid1(String inputString) {
        return inputString.matches("^[01]([01][01])*$");
    }

    public static boolean isValid2(String inputString) {
        return inputString.matches("(^0([01]{2})*)|(^1([01]{2})*[01]$)");
    }

    public static boolean isValid3(String inputString) {
        return inputString.matches("((1*01*){3})+");
    }

    public static boolean isValid4(String inputString) {
        return inputString.matches("^(?!11$|111$)[01]*$");
        //^(?!.*(11|111))[01]+$
    }

    public static boolean isValid5(String inputString) {
        return inputString.matches("^1(([01]1)|[01]$)*");
    }

    public static boolean isValid6(String inputString) {
        return inputString.matches("(0+0+1?0*)|(0*1?0+0+)|(0+1?0+)");
    }

    public static boolean isValid7(String inputString) {
        return inputString.matches("^(0|10)+1?$|1");
    }
}
