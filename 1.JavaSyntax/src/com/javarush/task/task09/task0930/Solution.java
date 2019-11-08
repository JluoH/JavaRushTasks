package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }
        String[] array = list.toArray(new String[0]);
        sort(array);
        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        ArrayList<Integer> l3 = new ArrayList<>();
        ArrayList<String> l4 = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                l1.add(i);
                l3.add(Integer.parseInt(array[i]));
            } else {
                l2.add(i);
                l4.add(array[i]);
            }
        }
        Collections.sort(l3);
        Collections.reverse(l3);
        for (int i = l4.size(); i > 1; i--) {
            for (int j = 0; j < i-1; j++) {
                if (isGreaterThan(l4.get(j), l4.get(j + 1))) {
                    String s = l4.get(j + 1);
                    l4.set(j + 1, l4.get(j));
                    l4.set(j, s);
                }
            }
        }
        for (int i = 0; i < l1.size(); i++) {
            array[l1.get(i)] = String.valueOf(l3.get(i));
        }
        for (int i = 0; i < l2.size(); i++) {
            array[l2.get(i)] = l4.get(i);
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }

    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
