package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add(buff.readLine());
        }
        String s = list.get(0);
        int u = 0;
        String h = list.get(0);
        int y = 0;
        for (int i = 1; i < 10; i++) {
            if (list.get(i).length() > s.length()) {
                s = list.get(i);
                u = i;
            }
            if (list.get(i).length() < h.length()) {
                h = list.get(i);
                y = i;
            }
        }
        if (u < y) {
            System.out.println(list.get(u));
        } else System.out.println(list.get(y));
    }
}
