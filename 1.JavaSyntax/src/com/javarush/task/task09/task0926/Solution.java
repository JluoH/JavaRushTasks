package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> l = new ArrayList<>(5);
        int[] a1 = {5, 5, 5, 5, 5};
        int[] a2 = {5, 5};
        int[] a3 = {5, 5, 5, 5};
        int[] a4 = {5, 5, 5, 5, 5, 5, 5};
        int[] a5 = {};
        l.add(a1);
        l.add(a2);
        l.add(a3);
        l.add(a4);
        l.add(a5);
        return l;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
