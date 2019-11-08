package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd");
        Date d = s1.parse(buff.readLine());
        SimpleDateFormat s2 = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        System.out.println(s2.format(d).toUpperCase());
    }
}
