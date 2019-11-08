package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
        ArrayList<Double> list1 = new ArrayList<>();
        for (Double value : map.values()) {
            list1.add(value);
        }
        double max = Collections.max(list1);
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (entry.getValue().equals(max)) {
                System.out.println(entry.getKey());
            }
        }
        bre.close();
    }
}
