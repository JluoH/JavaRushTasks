package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String ssylka = bufferedReader.readLine();
        ssylka = ssylka.split("\\?")[1];
        String s[] = ssylka.split("&");
        String value = "";
        try {
            value = ssylka.split("obj=")[1];
        } catch (Exception e) {
        }
        value = value.split("&")[0];
        for (String s1 : s) {
            s1 = s1.split("=")[0];
            System.out.print(s1 + " ");
        }
        System.out.println();
        if (!value.equals("")) {
            try {
                alert(Double.parseDouble(value));
            } catch (NumberFormatException e) {
                alert(value);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
