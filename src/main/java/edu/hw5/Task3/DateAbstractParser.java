package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

public abstract class DateAbstractParser {
    private DateAbstractParser next;

    public static DateAbstractParser link(DateAbstractParser first, DateAbstractParser... chain) {
        DateAbstractParser head = first;
        for (DateAbstractParser nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public abstract Optional<LocalDate> parseDate(String string);

    protected Optional<LocalDate> tryParse(String string) {
        Optional<LocalDate> optionalLocalDate = parseDate(string);
        if (optionalLocalDate.isEmpty() && next != null) {
            optionalLocalDate = next.tryParse(string);
        }

        return optionalLocalDate;
    }
}
