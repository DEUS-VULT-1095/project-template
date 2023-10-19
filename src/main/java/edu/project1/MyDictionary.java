package edu.project1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyDictionary implements Dictionary {
    private final List<String> list = new ArrayList<>();

    {
        list.add("honey");
        list.add("money");
        list.add("bunny");
    }

    @Override
    public String getWord() {
        Collections.shuffle(list);
        return list.get(0);
    }
}
