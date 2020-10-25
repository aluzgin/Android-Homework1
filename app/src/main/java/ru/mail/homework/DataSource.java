package ru.mail.homework;

import java.util.ArrayList;

public class DataSource {

    private static final DataSource ourInstance = new DataSource();
    private final ArrayList<Integer> list;

    private DataSource() {
        list = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }
    }

    static DataSource getInstance() {
        return ourInstance;
    }

    public ArrayList<Integer> getData() {
        return list;
    }
}