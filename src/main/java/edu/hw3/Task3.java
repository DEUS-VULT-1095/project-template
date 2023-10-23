package edu.hw3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Task3 {

    private Task3() {
    }

    public static <T> Map<T, Integer> freqDict(List<T> list) {
        Map<T, Integer> map = new HashMap<>();

        for (T next: list) {
            if (!map.containsKey(next)) {
                map.put(next, 1);
            } else {
                map.put(next, map.get(next) + 1);
            }
        }

        return map;
    }
}
