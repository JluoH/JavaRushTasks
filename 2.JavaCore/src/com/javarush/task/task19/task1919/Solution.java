package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bre = new BufferedReader(new FileReader(args[0]));
        ArrayList<String> list = new ArrayList<>();
        while (bre.ready()) {
            list.add(bre.readLine());
        }
        TreeMap<String, Double> map = new TreeMap<>();
        for (String s : list) {
            String h = s.split(" ")[0];
            double i = Double.parseDouble(s.split(" ")[1]);
            if (map.containsKey(h)) {
                map.put(h, map.get(h) + i);
            } else map.put(h, i);
        }
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        bre.close();
    }
}
