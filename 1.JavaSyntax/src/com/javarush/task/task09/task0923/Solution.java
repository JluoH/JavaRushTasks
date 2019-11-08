package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String mmm = buff.readLine();
        char[] ch = mmm.toCharArray();
        String m1 = "";
        String m2 = "";
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != ' ') {
                if (isVowel(ch[i])) {
                    m1 += ch[i] + " ";
                } else {
                    m2 += ch[i] + " ";
                }
            }
        }
        System.out.println(m1);
        System.out.println(m2);
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}