package com.javarush.task.task34.task3409;

import java.io.IOException;
import java.util.Map;
import java.util.WeakHashMap;

/* 
Настраиваем логгер
*/
public class Solution {
    public static void main(String args[]) throws IOException, InterruptedException {
        Map map = new WeakHashMap();
        Object o = new Object();
        map.put(o, 500);
        o = null;
        System.out.println(map.size());
        System.gc();
        Thread.sleep(1000);
        System.out.println(map.size());
    }
}
