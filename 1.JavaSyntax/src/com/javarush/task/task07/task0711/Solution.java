package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            list.add(0, buff.readLine());
        }
        String q;
        for (int i = 0; i < 13; i++) {
            q = list.get(4);
            list.remove(4);
            list.add(0, q);
        }
        for (String l : list
        ) {
            System.out.println(l);
        }
    }
}
