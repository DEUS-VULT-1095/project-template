package edu.hw3;

import java.util.Comparator;
import java.util.List;

public final class Task5 {
    private static final Comparator<String> ASC_COMPARATOR = (o1, o2) -> {
        String surname1 = o1.split(" ")[1];
        String surname2 = o2.split(" ")[1];
        return surname1.compareTo(surname2);
    };

    private static final Comparator<String> DESC_COMPARATOR = (o1, o2) -> {
        String surname1 = o1.split(" ")[1];
        String surname2 = o2.split(" ")[1];
        return surname2.compareTo(surname1);
    };

    private Task5() {
    }

    public static List<String> parseContacts(List<String> contactList, String sortOrder) {
        switch (sortOrder) {
            case "ASC" -> contactList.sort(ASC_COMPARATOR);
            case "DESC" -> contactList.sort(DESC_COMPARATOR);
            default -> throw new RuntimeException("Wrong sort type");
        }

        return contactList;
    }
}
