package com.javarush.task.task22.task2210;

import java.util.Arrays;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTokens("level22.lesson13.task01", ".")));
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer st = new StringTokenizer(query, delimiter);
        String[] mass = new String[st.countTokens()];
        int i = 0;
        while (st.hasMoreTokens()) {
            mass[i] = st.nextToken();
            i++;
        }
        return mass;
    }
}
