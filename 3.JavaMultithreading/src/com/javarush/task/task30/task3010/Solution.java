package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        try {
            String s = args[0].toLowerCase();
            char[] chars = s.toCharArray();
            char maxVal = 0;
            for (char aChar : chars) {
                if (String.valueOf(aChar).matches("[0-9a-z]")) {
                    if (aChar > maxVal) {
                        maxVal = aChar;
                    }
                } else {
                    System.out.println("incorrect");
                    return;
                }
            }
            if (maxVal == '0') {
                maxVal = '1';
            }
            System.out.println(Integer.parseInt(String.valueOf(maxVal), Character.MAX_RADIX) + 1);
        } catch (Exception e) {

        }
    }
}