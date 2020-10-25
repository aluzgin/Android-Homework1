package ru.mail.homework;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    private static final DataSource ourInstance = new DataSource();
    private final List<Integer> list;

    private DataSource() {
        list = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }
    }
    static DataSource getInstance() {
        return ourInstance;
    }
    public List<Integer> getData() {
        return list;
    }
}
