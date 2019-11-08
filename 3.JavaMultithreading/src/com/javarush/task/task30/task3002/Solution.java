package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0xFF")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        if (s.toLowerCase().startsWith("0x")) {
            s = s.substring(2);
            return String.valueOf(Integer.parseInt(s, 16));
        } else if (s.toLowerCase().startsWith("0b")) {
            s = s.substring(2);
            return String.valueOf(Integer.parseInt(s, 2));
        } else if (s.toLowerCase().startsWith("0")) {
            return String.valueOf(Integer.parseInt(s, 8));
        } else {
            String.valueOf(Integer.parseInt(s));
            return s;
        }
    }
}
