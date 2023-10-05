package edu.hw1;

// task4
public class BrokenString {

    public static void main(String[] args) {
        System.out.println(fixString("123456"));
        System.out.println(fixString("hTsii  s aimex dpus rtni.g"));
        System.out.println(fixString("badce"));
        System.out.println(fixString(""));
    }

    public static String fixString(String brokenString) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < brokenString.length(); i += 2) {
            if (i != (brokenString.length() - 1)) {
                sb.append(brokenString.charAt(i + 1));
            }
            sb.append(brokenString.charAt(i));
        }

        return sb.toString();
    }
}
