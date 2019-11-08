package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {

    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader file2 = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        ArrayList<String> l1 = new ArrayList<>();
        ArrayList<String> l2 = new ArrayList<>();
        while (file1.ready()) {
            l1.add(file1.readLine());
        }
        file1.close();
        while (file2.ready()) {
            l2.add(file2.readLine());
        }
        file2.close();
        while (true) {
            try {
                if (l1.get(0).equals(l2.get(0))) {
                    lines.add((new LineItem(Type.SAME, l1.get(0))));
                    l1.remove(0);
                    l2.remove(0);
                } else if (l1.get(1).equals(l2.get(0))) {
                    lines.add(new LineItem(Type.REMOVED, l1.get(0)));
                    lines.add(new LineItem(Type.SAME, l1.get(1)));
                    l1.remove(0);
                    l2.remove(0);
                    l1.remove(0);
                } else {
                    lines.add(new LineItem(Type.ADDED, l2.get(0)));
                    lines.add(new LineItem(Type.SAME, l2.get(1)));
                    l2.remove(0);
                    l1.remove(0);
                    l2.remove(0);
                }
            } catch (IndexOutOfBoundsException e) {
                if (l1.isEmpty() && l2.isEmpty()) break;
                else if (l1.isEmpty()) {
                    lines.add(new LineItem(Type.ADDED, l2.get(0)));
                    l2.remove(0);
                } else if (l2.isEmpty()) {
                    lines.add(new LineItem(Type.REMOVED, l1.get(0)));
                    l1.remove(0);
                }
            }
        }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {

        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
