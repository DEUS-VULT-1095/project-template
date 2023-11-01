package edu.hw3;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Task3 {

    private Task3() {
    }

    public static <T> Map<T, Integer> freqDict(List<T> list) {
        return list.stream()
            .collect(Collectors.groupingBy(next -> next, Collectors.summingInt(next -> 1)));
    }
}
