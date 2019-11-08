package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String[] mass = s.split(" ");
        for (String s1 : mass) {
            if (!s1.isEmpty()) {
                String c = s1.substring(0, 1).toUpperCase() + s1.substring(1).toLowerCase();
                System.out.print(c + " ");
            }
        }
    }
}
