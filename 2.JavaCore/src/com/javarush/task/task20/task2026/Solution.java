package com.javarush.task.task20.task2026;

import java.util.ArrayList;

/*
Алгоритмы-прямоугольники
*/
public class Solution {

    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 1, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };
        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int kek = 0;
        ArrayList<Integer> l = new ArrayList<>();
        for (int i1 = 0; i1 < a.length; i1++) {
            int prev = 0;
            for (int i = 0; i < a[i1].length; i++) {
                if (a[i1][i] == 1) {
                    if (prev == 0 && !l.contains(i)) {
                        kek++;
                    }
                    if (!l.contains(i)) l.add(i);
                } else if (l.contains(i)) l.remove(Integer.valueOf(i));
                prev = a[i1][i];
            }
        }
        return kek;
    }
}
