package edu.hw1;

// task1
public class Movie {

    public static int minutesToSeconds(String time) {
        String[] timeArray = time.split(":");

        if (timeArray.length != 2) return -1;

        int min;
        int sec;

        try {
            min = Integer.parseInt(timeArray[0]);
            sec = Integer.parseInt(timeArray[1]);
        } catch (NumberFormatException e) {
            return -1;
        }

        if (sec > 59 || sec < 0 || min < 0) return -1;

        int resultSec = min * 60 + sec;

        return resultSec;
    }
}
