package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String h;
        HashMap<String, Integer> hm = new HashMap<>();
        while (true) {
            h = reader.readLine();
            if (h.isEmpty()) break;
            else {
                hm.put(reader.readLine(), Integer.parseInt(h));
            }
        }
        for (Map.Entry<String, Integer> stringIntegerEntry : hm.entrySet()) {
            System.out.println(stringIntegerEntry.getValue() + " " + stringIntegerEntry.getKey());
        }
    }
}
