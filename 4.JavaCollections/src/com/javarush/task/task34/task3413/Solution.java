package com.javarush.task.task34.task3413;

/* 
Кеш на основании SoftReference
*/

import java.lang.ref.WeakReference;

public class Solution {
    public static void main(String[] args) {
        WeakReference<Integer> reference = new WeakReference<>(128);
        reference = null;
        while (true) System.out.println(reference.get());

    }
}