package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(String.format("JavaRush - %d", "kepa"));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) {
            throw new TooShortStringException();
        }
        String[] mass = string.split(" ");
        if (mass.length < 5) {
            throw new TooShortStringException();
        }

        return mass[1]+ " " +mass[2]+ " " +mass[3]+ " " +mass[4];
    }

    public static class TooShortStringException extends RuntimeException {

    }
}
