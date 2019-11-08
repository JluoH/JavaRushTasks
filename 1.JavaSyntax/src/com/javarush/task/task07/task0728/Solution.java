package com.javarush.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
В убывающем порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }
        sort(array);
        for (int x : array) {
            System.out.println(x);
        }
    }


    public static void sort(int[] array) {
        Arrays.sort(array);
        int[] mass = new int[array.length];
        int i = 19;
        for (int d :
                array) {
            mass[i] = d;
            i--;
        }
        array = Arrays.copyOf(mass, mass.length);
    }
}
