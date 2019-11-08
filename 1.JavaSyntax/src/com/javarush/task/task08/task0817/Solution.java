package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("qq21", "bb");
        map.put("qdq", "bb1");
        map.put("gfqq", "bb2");
        map.put("qqht", "bb3");
        map.put("qqh", "bb4");
        map.put("qqh7", "bb1");
        map.put("qq65g", "bb1");
        map.put("55", "bb");
        map.put("qgfdaq", "bb");
        map.put("q56fq", "bb");
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        ArrayList<String> list = new ArrayList<String>();
        for (String s : map.values()) {
            list.add(s);
        }
        for (int i = 0; i < 10; i++) {
            String o = list.get(0);
            list.remove(0);
            for (String p : list) {
                if (p.equals(o)) {
                    removeItemFromMapByValue(map, p);
                }
            }
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
    }
}
