package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            strings.add(buff.readLine());
        }
        String g = strings.get(0);
        for (int i = 1; i < 5; i++) {
            if (g.length() > strings.get(i).length()) {
                g = strings.get(i);
            }
        }
        for (int i = 0; i < 5; i++) {
            if (g.length() == strings.get(i).length()) {
                System.out.println(strings.get(i));
            }
        }
    }
}
