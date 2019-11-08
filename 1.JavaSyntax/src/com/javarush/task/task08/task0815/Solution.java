package com.javarush.task.task08.task0815;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < 10; i++) {
            map.put("Oleg" + i, "Bedilo" + i);
        }
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int y = 0;
        for (String s : map.values()) {
            if (name.equals(s)) {
                y++;
            }
        }
        return y;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        int y = 0;
        for (String s : map.keySet()) {
            if (lastName.equals(s)) {
                y++;
            }
        }
        return y;
    }

    public static void main(String[] args) {
    }
}
