package edu.hw1;

// task1
public final class Movie {
    private static final int MAX_NUMBER_SEC_DISPLAY = 59;
    private static final int SEC_PER_MINUTE = 60;

    private Movie() {
    }

    public static int minutesToSeconds(String time) {
        String[] timeArray = time.split(":");

        if (timeArray.length != 2) {
            return -1;
        }

        int min;
        int sec;

        try {
            min = Integer.parseInt(timeArray[0]);
            sec = Integer.parseInt(timeArray[1]);
        } catch (NumberFormatException e) {
            return -1;
        }

        int maxNumberSecDisplay = MAX_NUMBER_SEC_DISPLAY;

        if (sec > maxNumberSecDisplay || sec < 0 || min < 0) {
            return -1;
        }

        int secPerMin = SEC_PER_MINUTE;

        int resultSec = min * secPerMin + sec;

        return resultSec;
    }
}
